package com.edupath.msroadmap.controller;

import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.repository.RoadmapRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/roadmaps")
public class RoadmapController {

    private final RoadmapRepository roadmapRepository;

    public RoadmapController(RoadmapRepository roadmapRepository) {
        this.roadmapRepository = roadmapRepository;
    }

    @GetMapping
    public List<Roadmap> getAllRoadmaps() {
        return roadmapRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roadmap> getRoadmapById(@PathVariable String id) {
        return roadmapRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Roadmap createRoadmap(@RequestBody Roadmap roadmap) {
        return roadmapRepository.save(roadmap);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoadmap(@PathVariable String id) {
        roadmapRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
