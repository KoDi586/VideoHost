package org.example.service;

import org.example.dto.LineVideoResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LineVideoService {

    public LineVideoResponseDTO create(LineVideoResponseDTO lineVideo, MultipartFile multipartFile) throws IOException;

    List<LineVideoResponseDTO> getAll();

    void createTest(MultipartFile multipartFile) throws IOException;
}
