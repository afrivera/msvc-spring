package com.afrivera.course.client;

import com.afrivera.course.controller.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8581")
public interface StudentClient {

    @GetMapping("/Student/v1/search-course/{courseId}")
    List<StudentDTO> findallStudentByCourseId(@PathVariable Long courseId);
}
