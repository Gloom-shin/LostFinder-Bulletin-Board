package com.lostfinder.image.controller;

import com.lostfinder.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage( @RequestParam("category") String category,
                                          @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>( imageService.uploadFileV1(category, multipartFile),HttpStatus.CREATED);
    }
}
