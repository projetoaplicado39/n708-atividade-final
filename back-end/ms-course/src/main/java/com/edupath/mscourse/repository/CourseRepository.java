package com.edupath.mscourse.repository;

import com.edupath.mscourse.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> findByStepIdsContains(String stepId);
}
