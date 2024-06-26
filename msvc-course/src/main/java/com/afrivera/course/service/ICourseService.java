package com.afrivera.course.service;

import com.afrivera.course.controller.dto.CourseRequest;
import com.afrivera.course.controller.dto.CourseResponse;
import com.afrivera.course.entity.CourseEntity;
import com.afrivera.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseResponse> findAll();
    CourseResponse findById(Long id);
    CourseResponse save(CourseRequest cr);


    StudentByCourseResponse findStudentByCourseId(Long courseId);
}
