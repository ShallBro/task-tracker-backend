package org.example.task_tracker_backend.exception;

public class EmailAlreadyTakenException extends RuntimeException {
  public EmailAlreadyTakenException(String error) {
    super("Пользователь с таким email " + error + " уже существует");
  }
}
