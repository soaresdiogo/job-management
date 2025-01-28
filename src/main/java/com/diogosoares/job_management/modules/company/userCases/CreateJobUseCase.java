package com.diogosoares.job_management.modules.company.userCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.exceptions.CompanyNotFoundException;
import com.diogosoares.job_management.modules.company.entities.JobEntity;
import com.diogosoares.job_management.modules.company.repositories.CompanyRepository;
import com.diogosoares.job_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
