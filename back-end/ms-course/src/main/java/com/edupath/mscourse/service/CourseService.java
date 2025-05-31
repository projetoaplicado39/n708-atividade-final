package com.edupath.mscourse.service;

import com.edupath.mscourse.model.Course;
import com.edupath.mscourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findAll() {
        return repository.findAll();
    }

    public Optional<Course> findById(String id) {
        return repository.findById(id);
    }

    public Course save(Course course) {
        return repository.save(course);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
