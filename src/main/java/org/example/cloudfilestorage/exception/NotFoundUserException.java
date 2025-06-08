package org.example.cloudfilestorage.exception;

public class NotFoundUserException extends RuntimeException{
  public NotFoundUserException(int id) {
    super("Пользователь с таким id " + id + " не найден");
  }
}
