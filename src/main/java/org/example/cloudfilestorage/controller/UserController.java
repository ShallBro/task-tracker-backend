package org.example.cloudfilestorage.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.cloudfilestorage.dto.UserDTO;
import org.example.cloudfilestorage.service.UserService;
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

  @PostMapping("/post")
  public void postUser(@RequestBody UserDTO userDTO, HttpServletResponse response) {
    response.setHeader("Authorization", "Bearer " + userService.register(userDTO));
    response.setHeader("Access-Control-Expose-Headers", "Authorization");
  }

  @GetMapping("/get")
  public UserDTO getUser(@RequestParam int id) {
    return userService.getUser(id);
  }
}
