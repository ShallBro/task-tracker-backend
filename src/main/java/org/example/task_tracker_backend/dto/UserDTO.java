package org.example.task_tracker_backend.dto;

import lombok.Data;

@Data
public class UserDTO {
  // TODO: Сделать валидацию по мылу и минимальному паролю
  private String email;
  private String password;
}
