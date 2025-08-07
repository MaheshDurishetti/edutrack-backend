package com.edutrack.controller;

import com.edutrack.model.Teacher;
import com.edutrack.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/register")
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.registerTeacher(teacher));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginTeacher(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Teacher teacher = teacherService.loginTeacher(email, password);

        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
