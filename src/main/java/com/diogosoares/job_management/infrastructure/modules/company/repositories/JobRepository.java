package com.diogosoares.job_management.infrastructure.modules.company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogosoares.job_management.domain.modules.company.enterprise.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
  List<JobEntity> findByDescriptionContainingIgnoreCase(String title);

  List<JobEntity> findByCompanyId(UUID companyId);
}
