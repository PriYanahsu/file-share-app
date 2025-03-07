package com.project.filesharingapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.filesharingapp.entity.FileEntity;


@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    List<FileEntity> findByExpiryTimeBefore(LocalDateTime now);

}
