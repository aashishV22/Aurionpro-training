package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.FileDb;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String>{

}
