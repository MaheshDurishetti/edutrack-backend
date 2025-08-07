package com.edutrack.service;

import com.edutrack.model.Teacher;
import com.edutrack.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher registerTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher loginTeacher(String email, String password) {
        return teacherRepository.findByEmail(email)
                .filter(t -> t.getPassword().equals(password))
                .orElse(null);
    }
}
