package com.thanhson.bookhup.service;

import com.thanhson.bookhup.exception.ResourceNotFoundException;
import com.thanhson.bookhup.model.Progress;
import com.thanhson.bookhup.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Progress save(Progress progress) {
        return progressRepository.save(progress);
    }

    public void delete(Progress progress) {
        progressRepository.delete(progress);
    }

    public Progress getProgressById(Long progressId) {
        return progressRepository.findById(progressId).orElse(null);
    }
}
