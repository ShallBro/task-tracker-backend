package org.example.task_tracker_backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.task_tracker_backend.dto.TaskDTO;
import org.example.task_tracker_backend.dto.UserDTO;
import org.example.task_tracker_backend.service.TaskService;
import org.example.task_tracker_backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final TaskService taskService;

  @PostMapping("/post")
  public void postUser(@RequestBody UserDTO userDTO, HttpServletResponse response) {
    response.setHeader("Authorization", "Bearer " + userService.register(userDTO));
    response.setHeader("Access-Control-Expose-Headers", "Authorization");
  }

  @GetMapping("/get")
  public UserDTO getUser(@RequestParam int id) {
    return userService.getUser(id);
  }

  @GetMapping("/tasks")
  public List<TaskDTO> getTasks(@RequestParam int id) {
    return taskService.getList(id);
  }
}
