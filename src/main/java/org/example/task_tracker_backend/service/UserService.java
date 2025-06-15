package org.example.task_tracker_backend.service;

import static java.lang.invoke.MethodHandles.lookup;

import lombok.RequiredArgsConstructor;
import org.example.task_tracker_backend.dto.UserDTO;
import org.example.task_tracker_backend.entity.User;
import org.example.task_tracker_backend.exception.EmailAlreadyTakenException;
import org.example.task_tracker_backend.exception.NotFoundUserException;
import org.example.task_tracker_backend.mapper.GenericMapper;
import org.example.task_tracker_backend.repository.UserRepository;
import org.example.task_tracker_backend.security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final JwtProvider jwtProvider;

  private final GenericMapper<UserDTO, User> genericMapper;

  private final PasswordEncoder passwordEncoder;

  private static final Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass());


  public String register(UserDTO userDTO) {
    userRepository.findByEmail(userDTO.getEmail()).ifPresent(user -> {
      throw new EmailAlreadyTakenException(userDTO.getEmail());
    });
    LOGGER.info("Save user in repository: {}", userDTO.getEmail());
    userRepository.save(new User(userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword())));
    LOGGER.info("Generate token for {}", userDTO.getEmail());
    // В кафку отправляем на сервис с рассылками
    return jwtProvider.generateToken(userDTO.getEmail());
  }

  @Transactional(readOnly = true)
  public UserDTO getUser(int id) {
    LOGGER.info("Get user by id: {}", id);
    return genericMapper.toDto(userRepository.findById((long) id).orElseThrow(() -> new NotFoundUserException(id)));
  }
}
