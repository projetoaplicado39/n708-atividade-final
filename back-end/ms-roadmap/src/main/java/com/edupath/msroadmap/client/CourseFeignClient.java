package com.edupath.msroadmap.client;

import com.edupath.msroadmap.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "course-service", url = "${course.service.url}")
public interface CourseFeignClient {

    @GetMapping("/step/{stepId}")
    List<CourseDTO> getCoursesByStepId(@PathVariable("stepId") String stepId);
}
