package org.example.cloudfilestorage.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.cloudfilestorage.dto.UserDTO;
import org.example.cloudfilestorage.service.AuthorizationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

  private final AuthorizationService authorizationService;

  @PostMapping("/auth/login")
  public void authLogin(@RequestBody UserDTO userDTO, HttpServletResponse response) {
    response.setHeader("Authorization", "Bearer " + authorizationService.auth(userDTO));
    response.setHeader("Access-Control-Expose-Headers", "Authorization");
  }
}
