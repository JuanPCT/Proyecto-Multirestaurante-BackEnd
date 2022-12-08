package com.multiristorante.app.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileService {

    private static final String FILE_DIRECTORY = "/home/user/web/images";

    private final Path rootLocation = Paths.get(FILE_DIRECTORY);

    public void storeFile(MultipartFile file) throws IOException {
        Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(FILE_DIRECTORY+ "/" + filename);
            System.out.println(file.toString());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
}