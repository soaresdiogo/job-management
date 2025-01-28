package com.diogosoares.job_management.application.exceptions;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(){
      super("User not found");
  }
}
