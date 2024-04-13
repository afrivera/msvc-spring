package com.afrivera.course.service.impl;

import com.afrivera.course.client.StudentClient;
import com.afrivera.course.controller.dto.CourseRequest;
import com.afrivera.course.controller.dto.CourseResponse;
import com.afrivera.course.controller.dto.StudentDTO;
import com.afrivera.course.entity.CourseEntity;
import com.afrivera.course.http.response.StudentByCourseResponse;
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
    private final StudentClient studentClient;

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(course -> {
                    CourseResponse cr = new CourseResponse();
                    cr.setCourseId(course.getId());
                    cr.setName(course.getName());
                    cr.setTeacher(course.getTeacher());
                    return cr;
                }).collect(Collectors.toList());
    }

    @Override
    public CourseResponse findById(Long id) {
        CourseEntity ce = courseRepository.findById(id).orElseThrow();

        return CourseResponse.builder()
                .name(ce.getName())
                .courseId(ce.getId())
                .teacher(ce.getTeacher())
                .build();
    }

    @Override
    public CourseResponse save(CourseRequest cr) {
        CourseEntity ce = courseRepository.save(CourseEntity.builder()
                .name(cr.getName())
                .teacher(cr.getTeacher())
                .build());
        return CourseResponse.builder()
                .teacher(ce.getName())
                .courseId(ce.getId())
                .name(ce.getName())
                .build();
    }

    @Override
    public StudentByCourseResponse findStudentByCourseId(Long courseId){
        // consultar si existe el curso
        CourseEntity ce = courseRepository.findById(courseId).orElseThrow();

        // obtener estudiantes
        List<StudentDTO> students = studentClient.findallStudentByCourseId(courseId);

        return StudentByCourseResponse.builder()
                .courseName(ce.getName())
                .teacher(ce.getTeacher())
                .students(students)
                .build();

    }
}
