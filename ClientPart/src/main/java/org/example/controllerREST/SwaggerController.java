package org.example.controllerREST;

import lombok.RequiredArgsConstructor;
import org.example.dto.LineVideoResponseDTO;
import org.example.service.LineVideoService;
import org.example.service.LineVideoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video-list")
@RequiredArgsConstructor
public class SwaggerController {

    private final LineVideoService service = new LineVideoServiceImpl();

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LineVideoResponseDTO> addLineDTO(@RequestBody LineVideoResponseDTO lineVideoResponseDTO,
                                                           @RequestParam MultipartFile multipartFile) throws IOException {

        return ResponseEntity.ok(service.create(lineVideoResponseDTO, multipartFile));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LineVideoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping(value = "/create/test", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createTest(@RequestParam() MultipartFile multipartFile) throws IOException {
        service.createTest(multipartFile);
        return ResponseEntity.ok("successful");
    }
}
