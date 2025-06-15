package org.example.task_tracker_backend.exception;

public class NotFoundUserException extends RuntimeException{
  public NotFoundUserException(int id) {
    super("Пользователь с таким id " + id + " не найден");
  }
}
