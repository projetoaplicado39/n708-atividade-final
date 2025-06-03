package com.edupath.msroadmap.dto;

import com.edupath.msroadmap.model.RoadmapStep;

import java.util.List;

public class RoadmapStepWithCoursesDTO {
    private RoadmapStep step;
    private List<CourseDTO> courses;

    public RoadmapStepWithCoursesDTO() {
    }

    public RoadmapStepWithCoursesDTO(RoadmapStep step, List<CourseDTO> courses) {
        this.step = step;
        this.courses = courses;
    }

    public RoadmapStep getStep() {
        return step;
    }

    public void setStep(RoadmapStep step) {
        this.step = step;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
