package com.diogosoares.job_management.domain.modules.candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.domain.modules.company.enterprise.entities.JobEntity;
import com.diogosoares.job_management.infrastructure.modules.company.repositories.JobRepository;

@Service
public class ListAllJobsByFilterUseCase {

  @Autowired
  private JobRepository jobRepository;

  public List<JobEntity> execute(String filter) {
    return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
  }
}
