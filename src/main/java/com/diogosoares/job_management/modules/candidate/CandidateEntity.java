package com.diogosoares.job_management.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

  private UUID id;

  private String name;

  @NotBlank()
  @Pattern(regexp = "\\s+", message = "Username should not be empty")
  private String username;

  @Email(message = "Email should be valid")
  private String email;

  @Length(min = 6, max = 30, message = "Password should be between 6 and 30 characters")
  private String password;

  private String description;
  private String curriculum;
}
