package com.edupath.msroadmap.repository;

import com.edupath.msroadmap.model.RoadmapStep;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadmapStepRepository extends MongoRepository<RoadmapStep, String> {
    List<RoadmapStep> findByRoadmapIdOrderByOrderIndexAsc(String roadmapId);
}
