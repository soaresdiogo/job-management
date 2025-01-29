package com.diogosoares.job_management.domain.modules.candidate.enterprise.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "candidates")
public class CandidateEntity {

  @Id
  @GeneratedValue(generator = "UUID")
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

  @CreationTimestamp
  private LocalDateTime createdAt;
}
