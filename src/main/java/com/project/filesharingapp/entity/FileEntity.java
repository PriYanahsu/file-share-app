package com.project.filesharingapp.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String uploadedBy;
    private LocalDateTime uploadTime;
    private LocalDateTime expiryTime;


    @Lob
    @Column(name = "file_data", columnDefinition="LONGBLOB")
    private byte[] fileData;

    public void setFileName(String originalFilename) {
        this.fileName = originalFilename;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public void setUploadTime(LocalDateTime now) {
        this.uploadTime = now;
    }

    public void setExpiryTime(LocalDateTime localDateTime) {
        this.expiryTime = localDateTime;
    }

    public void setFileData(byte[] bytes) {
        this.fileData = bytes;
    }

    public String getFileName() {
        return fileName;
    }
}