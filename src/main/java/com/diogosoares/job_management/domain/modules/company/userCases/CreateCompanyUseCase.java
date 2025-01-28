package com.diogosoares.job_management.domain.modules.company.userCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.application.exceptions.UserFoundException;
import com.diogosoares.job_management.domain.modules.company.enterprise.entities.CompanyEntity;
import com.diogosoares.job_management.infrastructure.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent(user -> {
          throw new UserFoundException();
        });

    var password = passwordEncoder.encode(companyEntity.getPassword());
    companyEntity.setPassword(password);

    return this.companyRepository.save(companyEntity);
  }
}