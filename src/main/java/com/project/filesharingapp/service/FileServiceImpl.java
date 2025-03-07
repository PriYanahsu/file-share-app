package com.project.filesharingapp.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.filesharingapp.entity.FileEntity;
import com.project.filesharingapp.model.FileModel;
import com.project.filesharingapp.repository.FileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.filesharingapp.entity.FileEntity;
import com.project.filesharingapp.model.FileModel;
import com.project.filesharingapp.repository.FileRepository;
import com.project.filesharingapp.exception.FileNotFoundException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public FileRepository filerepository;

    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy) throws IOException {

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setUploadedBy(uploadedBy);
        fileEntity.setUploadTime(LocalDateTime.now());
        fileEntity.setExpiryTime(LocalDateTime.now().plusDays(1)); // 24 hours expiry
        fileEntity.setFileData(file.getBytes());
        filerepository.save(fileEntity);
        FileModel fileModel = new FileModel();
        BeanUtils.copyProperties(fileEntity, fileModel);
        return ResponseEntity.ok().body(fileModel);
    }

    public ResponseEntity<?> getFile(int id)  {
        Optional<FileEntity> fileEntityOptional = filerepository.findById(id);

        if (fileEntityOptional.isPresent()) {
            FileEntity fileEntity = fileEntityOptional.get();
            FileModel fileModel = new FileModel();
            BeanUtils.copyProperties(fileEntity, fileModel);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                    .body(fileModel.getFileData());
        } else {
            throw new FileNotFoundException("File not found");
        }
    }

    public ResponseEntity<?> deleteFile(int id) {

        Optional <FileEntity> entity = filerepository.findById(id);
        if(entity.isPresent()){
            filerepository.delete(entity.get());
            return ResponseEntity.ok().body("Deleted successfully");
        }
        else{
            throw new FileNotFoundException("File not found");
        }

    }

    @Scheduled(cron = "0 0 * * * *")
    public void deleteExpiredFiles() {
        List<FileEntity> expiredFiles = filerepository.findByExpiryTimeBefore(LocalDateTime.now());
        expiredFiles.forEach(filerepository::delete);
        System.out.println("Deleted expired files at: " + LocalDateTime.now());
    }


    private FileModel convertToModel(FileEntity entity) {
        FileModel model = new FileModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }


    @Override
    public List<FileModel> getAllFiles() {

        List<FileEntity> entityList = filerepository.findAll();
        return entityList.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> shareFile(int id) {
        Optional <FileEntity> fileEntity = filerepository.findById(id);
        if(fileEntity.isPresent()){
            FileEntity file = fileEntity.get();
            FileModel fileModel = new FileModel();
            BeanUtils.copyProperties(file, fileModel);
            return ResponseEntity.ok().body(fileModel);
        }
        else{
            throw new FileNotFoundException("File not found");
        }
    }

}
