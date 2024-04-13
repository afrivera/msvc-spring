package com.afrivera.student.controller;

import com.afrivera.student.entity.StudentEntity;
import com.afrivera.student.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student){
        return new ResponseEntity(studentService.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/search-course/{courseId}")
    public ResponseEntity<List<StudentEntity>> findByIdCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(studentService.findByCourseId(courseId));
    }
}
