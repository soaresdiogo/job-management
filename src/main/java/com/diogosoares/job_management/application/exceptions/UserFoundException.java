package com.diogosoares.job_management.application.exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("Username already exists");
  }
}
