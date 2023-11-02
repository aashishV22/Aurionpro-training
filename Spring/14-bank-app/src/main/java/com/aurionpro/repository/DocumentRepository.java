package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String>{


	@Query("UPDATE Document d SET d.requestStatus = ?1 WHERE (d.requestId = ?2)")
	void save(String status, int requestId);

}
