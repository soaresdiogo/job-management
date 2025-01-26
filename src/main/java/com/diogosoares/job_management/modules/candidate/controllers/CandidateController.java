package com.diogosoares.job_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogosoares.job_management.modules.candidate.CandidateEntity;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @PostMapping("/")
  public void create(@Valid @RequestBody CandidateEntity candidate) {
    System.out.println(candidate);
  }

}
