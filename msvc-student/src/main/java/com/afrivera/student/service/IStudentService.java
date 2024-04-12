package com.afrivera.student.service;

import com.afrivera.student.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {

    List<StudentEntity> findAll();

    StudentEntity findById(Long id);

    StudentEntity save(StudentEntity student);

    List<StudentEntity> findByCourseId(Long courseId);
}
