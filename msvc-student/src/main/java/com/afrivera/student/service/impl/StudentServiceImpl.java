package com.afrivera.student.service.impl;

import com.afrivera.student.entity.StudentEntity;
import com.afrivera.student.persistence.StudentRepository;
import com.afrivera.student.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentEntity> findByCourseId(Long courseId) {
        return studentRepository.findAllStudents(courseId);
    }
}
