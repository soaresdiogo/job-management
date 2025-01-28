package com.diogosoares.job_management.domain.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogosoares.job_management.application.exceptions.JobNotFoundException;
import com.diogosoares.job_management.application.exceptions.UserNotFoundException;
import com.diogosoares.job_management.domain.modules.candidate.enterprise.entities.ApplyJobEntity;
import com.diogosoares.job_management.infrastructure.modules.candidate.repositories.ApplyJobRepository;
import com.diogosoares.job_management.infrastructure.modules.candidate.repositories.CandidateRepository;
import com.diogosoares.job_management.infrastructure.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder()
        .candidateId(idCandidate)
        .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
