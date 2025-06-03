package com.edupath.mscourse.service;

import com.edupath.mscourse.model.Course;
import com.edupath.mscourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(String id) {
        return courseRepository.findById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findByStepId(String stepId) {
        return courseRepository.findByStepIdsContains(stepId);
    }
}
