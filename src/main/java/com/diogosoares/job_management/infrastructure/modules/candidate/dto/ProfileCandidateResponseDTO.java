package com.diogosoares.job_management.infrastructure.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

  @Schema(example = "Java developer")
  private String description;

  @Schema(example = "john.doe")
  private String username;

  @Schema(example = "john.doe@example.com")
  private String email;
  private UUID id;

  @Schema(example = "John Doe")
  private String name;
}
