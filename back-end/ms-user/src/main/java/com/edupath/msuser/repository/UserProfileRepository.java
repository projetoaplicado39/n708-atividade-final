package com.edupath.msuser.repository;

import com.edupath.msuser.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {}
