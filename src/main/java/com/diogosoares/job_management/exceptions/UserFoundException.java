package com.diogosoares.job_management.exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("Username already exists");
  }
}
