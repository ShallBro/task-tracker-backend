package org.example.task_tracker_backend.service;

import static java.lang.invoke.MethodHandles.lookup;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.task_tracker_backend.dto.TaskDTO;
import org.example.task_tracker_backend.entity.Task;
import org.example.task_tracker_backend.exception.NotFoundUserException;
import org.example.task_tracker_backend.mapper.GenericMapper;
import org.example.task_tracker_backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
  private final UserRepository userRepository;
  private final GenericMapper<TaskDTO, Task> genericMapper;
  private static final Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass());


  public List<TaskDTO> getList(int id) {
    LOGGER.info("Find user by {} and getTasks", id);
    List<Task> tasks = userRepository.findById((long) id).orElseThrow(() -> new NotFoundUserException(id)).getTasks();
    return genericMapper.toDtoList(tasks);
  }
}
