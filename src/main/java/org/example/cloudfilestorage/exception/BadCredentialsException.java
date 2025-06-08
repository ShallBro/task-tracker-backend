package org.example.cloudfilestorage.exception;

public class BadCredentialsException extends RuntimeException {
  public BadCredentialsException() {
    super("Введены неправильные учётные данные");
  }
}
