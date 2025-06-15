package org.example.cloudfilestorage.service;

import static java.lang.invoke.MethodHandles.lookup;

import lombok.RequiredArgsConstructor;
import org.example.cloudfilestorage.dto.UserDTO;
import org.example.cloudfilestorage.entity.User;
import org.example.cloudfilestorage.exception.BadCredentialsException;
import org.example.cloudfilestorage.exception.UsernameNotFoundException;
import org.example.cloudfilestorage.repository.UserRepository;
import org.example.cloudfilestorage.security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

  private final UserRepository userRepository;

  private final JwtProvider jwtProvider;

  private final PasswordEncoder passwordEncoder;

  private static final Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass());

  public String auth(UserDTO userDTO) {
    LOGGER.info("Find by email: {}", userDTO.getEmail());
    User user = userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException(userDTO.getEmail()));
    if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
      LOGGER.error("BadPassword: {}", userDTO.getPassword());
      throw new BadCredentialsException();
    }
    return jwtProvider.generateToken(userDTO.getEmail());
  }
}
