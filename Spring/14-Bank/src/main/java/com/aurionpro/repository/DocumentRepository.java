package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String>{

}
