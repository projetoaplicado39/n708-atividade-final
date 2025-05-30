package com.edupath.msuser.service;

import com.edupath.msuser.model.UserProfile;
import com.edupath.msuser.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    private final UserProfileRepository repository;

    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    public UserProfile getProfile(String userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public UserProfile updateProfile(String userId, UserProfile updatedProfile) {
        updatedProfile.setUserId(userId);
        return repository.save(updatedProfile);
    }
}
