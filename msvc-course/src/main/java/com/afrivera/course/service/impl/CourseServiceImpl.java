package com.afrivera.course.service.impl;

import com.afrivera.course.controller.dto.CourseRequest;
import com.afrivera.course.controller.dto.CourseResponse;
import com.afrivera.course.entity.CourseEntity;
import com.afrivera.course.persistence.ICourseRepository;
import com.afrivera.course.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map( course -> {
                    CourseResponse cr = new CourseResponse();
                    cr.setCourseId(course.getId());
                    cr.setName(course.getName());
                    cr.setTeacher(course.getTeacher());
                    return  cr;
                }).collect(Collectors.toList());
    }

    @Override
    public CourseResponse findById(Long id) {
        return null;
    }

    @Override
    public CourseResponse save(CourseRequest cr) {
        return null;
    }
}
