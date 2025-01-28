package com.diogosoares.job_management.domain.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.application.exceptions.UserNotFoundException;
import com.diogosoares.job_management.infrastructure.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.diogosoares.job_management.infrastructure.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTO execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new UserNotFoundException();
        });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId())
        .build();

    return candidateDTO;
  }
}
