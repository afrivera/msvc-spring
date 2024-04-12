package com.afrivera.student.persistence;

import com.afrivera.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s WHERE s.courseId = :courseId")
    List<StudentEntity> findAllStudents(Long courseId);
}
