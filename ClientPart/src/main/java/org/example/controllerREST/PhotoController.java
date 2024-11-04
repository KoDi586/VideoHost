package org.example.controllerREST;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getPhoto(@PathVariable long id) throws IOException {
        Resource imgFile = new ClassPathResource("static/photo/IMG_20241101_132617_444"+".jpg");

        byte[] imageBytes = Files.readAllBytes(imgFile.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}
