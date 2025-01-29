package com.diogosoares.job_management.infrastructure.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {

  @Schema(example = "Junior Developer Opportunity", requiredMode = RequiredMode.REQUIRED)
  private String description;

  @Schema(example = "GymPass, Udemy Access", requiredMode = RequiredMode.REQUIRED)
  private String benefits;

  @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
  private String level;
}
