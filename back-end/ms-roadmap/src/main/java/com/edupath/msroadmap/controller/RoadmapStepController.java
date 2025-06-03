package com.edupath.msroadmap.controller;

import com.edupath.msroadmap.client.CourseFeignClient;
import com.edupath.msroadmap.dto.CourseDTO;
import com.edupath.msroadmap.model.RoadmapStep;
import com.edupath.msroadmap.repository.RoadmapStepRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/roadmaps/{roadmapId}/steps")
public class RoadmapStepController {

    private final CourseFeignClient courseFeignClient;
    private final RoadmapStepRepository roadmapStepRepository;

    public RoadmapStepController(CourseFeignClient courseFeignClient, RoadmapStepRepository roadmapStepRepository) {
        this.courseFeignClient = courseFeignClient;
        this.roadmapStepRepository = roadmapStepRepository;
    }

    @GetMapping
    public List<RoadmapStep> getStepsByRoadmapId(@PathVariable String roadmapId) {
        return roadmapStepRepository.findByRoadmapIdOrderByOrderIndexAsc(roadmapId);
    }

    @PostMapping
    public RoadmapStep createStep(@PathVariable String roadmapId, @RequestBody RoadmapStep step) {
        step.setRoadmapId(roadmapId);
        return roadmapStepRepository.save(step);
    }

    @DeleteMapping("/{stepId}")
    public ResponseEntity<Void> deleteStep(@PathVariable String stepId) {
        roadmapStepRepository.deleteById(stepId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{stepId}/courses")
    public List<CourseDTO> getCoursesByStepId(@PathVariable String stepId) {
        return courseFeignClient.getCoursesByStepId(stepId);
    }
}
