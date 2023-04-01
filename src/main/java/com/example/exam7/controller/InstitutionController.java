package com.example.exam7.controller;

import com.example.exam7.dao.InstititionDishDao;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.exam7.service.InstitionDishesService;

@RestController("institutions/")
@RequiredArgsConstructor
public class InstitutionController {
    private final InstitionDishesService institionDishesService;
    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> serveFile(@PathVariable Long imageId) {
        Resource resource = institionDishesService.getById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }
}
