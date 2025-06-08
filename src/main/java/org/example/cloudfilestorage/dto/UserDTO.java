package org.example.cloudfilestorage.dto;

import lombok.Data;

@Data
public class UserDTO {
  // TODO: Сделать валидацию по мылу и минимальному паролю
  private String email;
  private String password;
}
