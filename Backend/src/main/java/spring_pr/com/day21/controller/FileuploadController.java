package spring_pr.com.day21.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class FileuploadController {
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        // Logic to handle file upload
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            return "File uploaded successfully:" + fileName;
        } catch (IOException e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }

}
