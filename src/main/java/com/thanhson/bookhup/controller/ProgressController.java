package com.thanhson.bookhup.controller;

import com.thanhson.bookhup.model.Progress;
import com.thanhson.bookhup.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @PostMapping("/create")
    public ResponseEntity<Progress> createProgress(@RequestBody @Valid Progress progress) {
        Progress createdProgress = progressService.save(progress);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProgress);
    }

    @DeleteMapping("/delete/{progressID}")
    public ResponseEntity<String> deleteProgress(@PathVariable Long progressID) {
        Progress progress = progressService.getProgressById(progressID);
        if (progress == null) {
            return ResponseEntity.notFound().build();
        }

        progressService.delete(progress);
        return ResponseEntity.ok("Progress deleted successfully.");
    }
}