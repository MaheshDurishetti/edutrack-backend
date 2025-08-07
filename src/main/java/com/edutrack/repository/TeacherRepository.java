package com.edutrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edutrack.model.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
}
