package com.edupath.msroadmap.service;

import com.edupath.msroadmap.model.Roadmap;
import com.edupath.msroadmap.model.RoadmapStep;
import com.edupath.msroadmap.repository.RoadmapRepository;
import com.edupath.msroadmap.repository.RoadmapStepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoadmapService {

    private final RoadmapRepository roadmapRepository;
    private final RoadmapStepRepository roadmapStepRepository;

    public RoadmapService(RoadmapRepository roadmapRepository, RoadmapStepRepository roadmapStepRepository) {
        this.roadmapRepository = roadmapRepository;
        this.roadmapStepRepository = roadmapStepRepository;
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
}
