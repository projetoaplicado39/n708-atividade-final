package com.edupath.mscourse.mapper;

import com.edupath.mscourse.dto.CourseDTO;
import com.edupath.mscourse.model.Course;
import com.edupath.mscourse.model.DifficultyLevel;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setUrl(course.getUrl());
        dto.setProvider(course.getProvider());
        dto.setDuration(course.getDuration());
        dto.setDifficultyLevel(course.getDifficultyLevel().name());  // Enum -> String
        dto.setStepIds(course.getStepIds());
        return dto;
    }

    public Course toEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setUrl(dto.getUrl());
        course.setProvider(dto.getProvider());
        course.setDuration(dto.getDuration());
        course.setDifficultyLevel(DifficultyLevel.valueOf(dto.getDifficultyLevel()));  // String -> Enum
        course.setStepIds(dto.getStepIds());
        return course;
    }
}
