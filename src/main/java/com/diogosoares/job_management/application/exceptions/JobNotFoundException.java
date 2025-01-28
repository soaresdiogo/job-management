package com.diogosoares.job_management.application.exceptions;

public class JobNotFoundException extends RuntimeException{
  public JobNotFoundException(){
      super("Job not found");
  }
}
