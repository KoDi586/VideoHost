package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.LineVideoResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.swagger.v3.core.util.AnnotationsUtils.getExtensions;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Slf4j
public class LineVideoServiceImpl implements LineVideoService {

    private static List<LineVideoResponseDTO> line = new ArrayList<>();
    @Value("${photo.directory}")
    private String photoDir = "C:\\\\Users\\\\hirof\\\\IdeaProjects\\\\VideoHost\\\\ClientPart\\\\src\\\\main\\\\resources\\\\static\\\\photo";

    @Override
    public LineVideoResponseDTO create(LineVideoResponseDTO lineVideo, MultipartFile multipartFile) throws IOException {
        log.info("working");
        Path filePath = null;
        try {
            filePath = Path.of(photoDir, "." + getExtensions(multipartFile.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("ошибка сохранения фотографии в БД");
        }
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (
                InputStream is = multipartFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        log.info("bytes: {}", Arrays.toString(multipartFile.getBytes()));
        log.info("contentType: {}", multipartFile.getContentType());
        log.info("size: {}", multipartFile.getSize());
        line.add(lineVideo);
        return lineVideo;
    }

    private String getExtensions(String fileName) {
        String extentions = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.debug("extentions is: {}", extentions);
        return extentions;
    }

    @Override
    public List<LineVideoResponseDTO> getAll() {
        return line;
    }

    @Override
    public void createTest(MultipartFile multipartFile) throws IOException{
        log.info("working");
        log.info("photodir = {}", photoDir);
        log.info(" = {}", photoDir);
        Path filePath = null;
        try {
            filePath = Path.of(photoDir, "." + getExtensions(multipartFile.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("ошибка сохранения фотографии в БД");
        }
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (
                InputStream is = multipartFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        log.info("working1");



        log.info("bytes: {}", Arrays.toString(multipartFile.getBytes()));
        log.info("contentType: {}", multipartFile.getContentType());
        log.info("size: {}", multipartFile.getSize());
    }
}
