package com.afrivera.course.controller;

import com.afrivera.course.controller.dto.CourseResponse;
import com.afrivera.course.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Course/v1")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourse(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
}
