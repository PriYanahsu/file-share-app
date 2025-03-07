package com.project.filesharingapp.controller;

import com.project.filesharingapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Controller
@RequestMapping()
public class Filecontroller {

    @Autowired
    private FileService fileService;

    @GetMapping("/home")
    public String index(Model model){
        model.addAttribute("Files", fileService.getAllFiles());
        return "listfiles";
    }

    @PostMapping("/upload")
    public String PostMethodName(@RequestParam("file") MultipartFile file, @RequestParam("uploadedBy") String uploadedBy) throws IOException{
        fileService.uploadFile(file, uploadedBy);
        return "redirect:/home";
    }

    @GetMapping("/Share/{id}")
    public String shareFile(@PathVariable int id, Model model) {
        ResponseEntity<?> fileResponse = fileService.shareFile(id);

        // Check if response has a valid body and is a success response
        if (fileResponse.getStatusCode().is2xxSuccessful() && fileResponse.getBody() != null) {
            String currentUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
            model.addAttribute("shareUrl", currentUrl);
            model.addAttribute("file", fileResponse.getBody());
            return "share-files"; // Correct Thymeleaf template reference
        }

        return "redirect:/"; // Redirect if file not found or failed response
    }


    @PostMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id){
        ResponseEntity<?> file = fileService.deleteFile(id);
        if(file.hasBody()){
            return "redirect:/home";
        }
        return "redirect:/home";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable("id") int id){
        return fileService.getFile(id);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
