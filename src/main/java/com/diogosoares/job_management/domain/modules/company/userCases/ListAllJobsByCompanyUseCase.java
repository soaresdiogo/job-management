package com.diogosoares.job_management.domain.modules.company.userCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.domain.modules.company.enterprise.entities.JobEntity;
import com.diogosoares.job_management.infrastructure.modules.company.repositories.JobRepository;

@Service
public class ListAllJobsByCompanyUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(UUID companyId){
        return this.jobRepository.findByCompanyId(companyId);
    }

}
