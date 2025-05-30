package com.edupath.msuser.repository;

import com.edupath.msuser.model.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserProgressRepository extends MongoRepository<UserProgress, String> {
    List<UserProgress> findByUserId(String userId);
}
