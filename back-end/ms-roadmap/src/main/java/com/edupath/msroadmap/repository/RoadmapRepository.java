package com.edupath.msroadmap.repository;

import com.edupath.msroadmap.model.Roadmap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadmapRepository extends MongoRepository<Roadmap, String> {
}
