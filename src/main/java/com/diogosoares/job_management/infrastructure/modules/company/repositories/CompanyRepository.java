package com.diogosoares.job_management.infrastructure.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogosoares.job_management.domain.modules.company.enterprise.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
  Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

  Optional<CompanyEntity> findByUsername(String username);
}
