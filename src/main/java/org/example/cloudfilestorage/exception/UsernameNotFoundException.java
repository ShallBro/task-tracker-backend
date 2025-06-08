package org.example.cloudfilestorage.exception;

public class UsernameNotFoundException extends RuntimeException {
  public UsernameNotFoundException(String message) {
    super("Пользователь с таким email " + message + " не найден");
  }
}
