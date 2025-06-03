package com.edupath.msuser.controller;

import com.edupath.msuser.model.UserProfile;
import com.edupath.msuser.model.UserProgress;
import com.edupath.msuser.service.UserProfileService;
import com.edupath.msuser.service.UserProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserProfileService profileService;
    private final UserProgressService progressService;

    public UserController(UserProfileService profileService, UserProgressService progressService) {
        this.profileService = profileService;
        this.progressService = progressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String id) {
        return ResponseEntity.ok(profileService.getProfile(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateProfile(@PathVariable String id,
                                                     @RequestBody UserProfile profile) {
        return ResponseEntity.ok(profileService.updateProfile(id, profile));
    }

    @GetMapping("/{id}/progress")
    public ResponseEntity<List<UserProgress>> getProgress(@PathVariable String id) {
        return ResponseEntity.ok(progressService.getProgressByUserId(id));
    }

    @PostMapping("/{id}/progress")
    public ResponseEntity<UserProgress> updateProgress(@PathVariable String id,
                                                       @RequestBody UserProgress progress) {
        progress.setUserId(id);
        return ResponseEntity.ok(progressService.saveProgress(progress));
    }
}
