package com.afrivera.course.persistence;

import com.afrivera.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity, Long> {
}
