package com.afrivera.student.controller;

import com.afrivera.student.entity.StudentEntity;
import com.afrivera.student.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Student/v1")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

}
