package com.edupath.msuser.service;

import com.edupath.msuser.model.UserProgress;
import com.edupath.msuser.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProgressService {
    private final UserProgressRepository repository;

    public UserProgressService(UserProgressRepository repository) {
        this.repository = repository;
    }

    public List<UserProgress> getProgressByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public UserProgress saveProgress(UserProgress progress) {
        return repository.save(progress);
    }
}
