package com.diogosoares.job_management.exceptions;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(){
      super("User not found");
  }
}
