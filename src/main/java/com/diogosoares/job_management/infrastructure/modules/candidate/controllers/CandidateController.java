package com.diogosoares.job_management.infrastructure.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diogosoares.job_management.domain.modules.candidate.enterprise.entities.CandidateEntity;
import com.diogosoares.job_management.domain.modules.candidate.useCases.ApplyJobCandidateUseCase;
import com.diogosoares.job_management.domain.modules.candidate.useCases.CreateCandidateUseCase;
import com.diogosoares.job_management.domain.modules.candidate.useCases.ListAllJobsByFilterUseCase;
import com.diogosoares.job_management.domain.modules.candidate.useCases.ProfileCandidateUseCase;
import com.diogosoares.job_management.domain.modules.company.enterprise.entities.JobEntity;
import com.diogosoares.job_management.infrastructure.modules.candidate.dto.ProfileCandidateResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/candidate")
@Tag(name = "Candidate", description = "Candidate Information")
public class CandidateController {
  @Autowired
  private CreateCandidateUseCase createCandidateUseCase;

  @Autowired
  private ProfileCandidateUseCase profileCandidateUseCase;

  @Autowired
  private ApplyJobCandidateUseCase applyJobCandidateUseCase;

  @Autowired
  private ListAllJobsByFilterUseCase listAllJobsByFilterUseCase;

  @PostMapping("/")
  @Operation(summary = "Candidate registration", description = "This endpoint is responsible for registering a new candidate")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(schema = @Schema(implementation = CandidateEntity.class))
      }),
      @ApiResponse(responseCode = "400", description = "Candidate already exists")
  })
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    try {
      var result = createCandidateUseCase.execute(candidateEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  @PreAuthorize("hasRole('CANDIDATE')")
  @Operation(summary = "Candidate Profile", description = "This endpoint is responsible for retrieving the candidate profile")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(schema = @Schema(implementation = ProfileCandidateResponseDTO.class))
      }),
      @ApiResponse(responseCode = "400", description = "Candidate not found")
  })
  @SecurityRequirement(name = "jwt_auth")
  public ResponseEntity<Object> get(HttpServletRequest request) {
    var idCandidate = request.getAttribute("candidate_id");

    try {
      var profile = this.profileCandidateUseCase
          .execute(UUID.fromString(idCandidate.toString()));
      return ResponseEntity.ok().body(profile);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/job")
  @PreAuthorize("hasRole('CANDIDATE')")
  @Operation(summary = "Listing of job openings available to the candidate", description = "This endpoint is responsible for listing the job openings available to the candidate.")
  @SecurityRequirement(name = "jwt_auth")
  @ApiResponses({
      @ApiResponse(responseCode = "200", content = {
          @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
      })
  })
  public List<JobEntity> findJobByFilter(@RequestParam String filter) {
    return this.listAllJobsByFilterUseCase.execute(filter);
  }

  @PostMapping("/job/apply")
  @PreAuthorize("hasRole('CANDIDATE')")
  @Operation(summary = "Candidate application for a job opening", description = "This endpoint is responsible for the candidate applying for a job opening.")
  @SecurityRequirement(name = "jwt_auth")
  public ResponseEntity<Object> applyJob(HttpServletRequest request, @RequestBody UUID idJob){

    var idCandidate = request.getAttribute("candidate_id");

    try{
          var result = this.applyJobCandidateUseCase.execute(UUID.fromString(idCandidate.toString()), idJob);
          return ResponseEntity.ok().body(result);
    }catch(Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}