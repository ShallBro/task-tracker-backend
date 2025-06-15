package org.example.task_tracker_backend.exception;

public class BadCredentialsException extends RuntimeException {
  public BadCredentialsException() {
    super("Введены неправильные учётные данные");
  }
}
