package com.edupath.msroadmap.service;

import com.edupath.msroadmap.client.CourseFeignClient;
import com.edupath.msroadmap.dto.CourseDTO;
import com.edupath.msroadmap.dto.RoadmapStepWithCoursesDTO;
import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.model.RoadmapStep;
import com.edupath.msroadmap.repository.RoadmapRepository;
import com.edupath.msroadmap.repository.RoadmapStepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoadmapService {

    private final CourseFeignClient courseFeignClient;
    private final RoadmapRepository roadmapRepository;
    private final RoadmapStepRepository roadmapStepRepository;

    public RoadmapService(RoadmapRepository roadmapRepository, RoadmapStepRepository roadmapStepRepository, CourseFeignClient courseFeignClient) {
        this.roadmapRepository = roadmapRepository;
        this.roadmapStepRepository = roadmapStepRepository;
        this.courseFeignClient = courseFeignClient;
    }

    public List<Roadmap> findAll() {
        return roadmapRepository.findAll();
    }

    public Optional<Roadmap> findById(String id) {
        return roadmapRepository.findById(id);
    }

    public Roadmap save(Roadmap roadmap) {
        return roadmapRepository.save(roadmap);
    }

    public void delete(String id) {
        roadmapRepository.deleteById(id);
    }

    public List<RoadmapStep> findStepsByRoadmapId(String roadmapId) {
        return roadmapStepRepository.findByRoadmapIdOrderByOrderIndexAsc(roadmapId);
    }

    public RoadmapStep saveStep(RoadmapStep step) {
        return roadmapStepRepository.save(step);
    }

    public List<CourseDTO> getCoursesByStepId(String stepId) {
        return courseFeignClient.getCoursesByStepId(stepId);
    }

    public List<RoadmapStepWithCoursesDTO> getStepsWithCoursesByRoadmapId(String roadmapId) {
        List<RoadmapStep> steps = roadmapStepRepository.findByRoadmapId(roadmapId);

        return steps.stream().map(step -> {
            List<CourseDTO> courses = courseFeignClient.getCoursesByStepId(step.getId());
            return new RoadmapStepWithCoursesDTO(step, courses);
        }).collect(Collectors.toList());
    }
}
