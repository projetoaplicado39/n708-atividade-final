package com.edupath.msroadmap.controller;

import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.model.RoadmapStep;
import com.edupath.msroadmap.service.RoadmapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roadmaps")
public class RoadmapController {

    private final RoadmapService service;

    public RoadmapController(RoadmapService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Roadmap>> getAllRoadmaps() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roadmap> getRoadmapById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Roadmap> createRoadmap(@RequestBody Roadmap roadmap) {
        return ResponseEntity.ok(service.save(roadmap));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoadmap(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/steps")
    public ResponseEntity<List<RoadmapStep>> getStepsByRoadmapId(@PathVariable String id) {
        return ResponseEntity.ok(service.findStepsByRoadmapId(id));
    }

    @PostMapping("/{id}/steps")
    public ResponseEntity<RoadmapStep> createStep(@PathVariable String id, @RequestBody RoadmapStep step) {
        step.setRoadmapId(id);
        return ResponseEntity.ok(service.saveStep(step));
    }
}
