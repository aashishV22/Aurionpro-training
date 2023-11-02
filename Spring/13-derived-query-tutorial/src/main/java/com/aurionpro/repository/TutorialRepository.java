package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
