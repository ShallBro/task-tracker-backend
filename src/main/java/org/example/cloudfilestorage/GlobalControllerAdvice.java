package org.example.cloudfilestorage;

import static org.example.cloudfilestorage.constants.ControllerAdviceConstant.MESSAGE;

import java.util.Collections;
import java.util.Map;
import org.example.cloudfilestorage.exception.BadCredentialsException;
import org.example.cloudfilestorage.exception.EmailAlreadyTakenException;
import org.example.cloudfilestorage.exception.NotFoundUserException;
import org.example.cloudfilestorage.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler(EmailAlreadyTakenException.class)
  public ResponseEntity<Map<String, String>> handleEmailTaken(EmailAlreadyTakenException ex) {
    return ResponseEntity
      .status(HttpStatus.CONFLICT)
      .body(Collections.singletonMap(MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(NotFoundUserException.class)
  public ResponseEntity<Map<String, String>> notFoundUser(NotFoundUserException ex) {
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(Collections.singletonMap(MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<Map<String, String>> userNameNotFound(UsernameNotFoundException ex) {
    return ResponseEntity
      .status(HttpStatus.UNAUTHORIZED)
      .body(Collections.singletonMap(MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<Map<String, String>> badCredentialsException(BadCredentialsException ex) {
    return ResponseEntity
      .status(HttpStatus.UNAUTHORIZED)
      .body(Collections.singletonMap(MESSAGE, ex.getMessage()));
  }
}
