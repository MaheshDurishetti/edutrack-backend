package com.edutrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutrack.model.Student;
import com.edutrack.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student loginStudent(String email, String password) {
        return studentRepository.findByEmail(email)
            .filter(student -> student.getPassword().equals(password))
            .orElse(null);
    }

}
