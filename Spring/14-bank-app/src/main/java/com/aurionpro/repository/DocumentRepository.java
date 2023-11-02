package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String>{

	@Transactional
	@Modifying
	@Query("UPDATE Document d SET d.requestStatus = :status WHERE d.requestId = :requestId")
	void saveByrequestId(@Param("status") String status, @Param("requestId") int requestId);

}
