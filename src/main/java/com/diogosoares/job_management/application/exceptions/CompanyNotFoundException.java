package com.diogosoares.job_management.application.exceptions;

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException() {
      super("Company not found");
  }
}
