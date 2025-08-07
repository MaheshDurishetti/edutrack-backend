package com.edutrack.controller;
	import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
	import com.edutrack.model.Student;
	import com.edutrack.service.StudentService;

	@RestController
	@RequestMapping("/api/students")
	@CrossOrigin(origins = "http://localhost:5173")
	public class StudentController {

	    @Autowired
	    private StudentService studentService;

	    @PostMapping("/register")
	    public Student registerStudent(@RequestBody Student student) {
	        return studentService.registerStudent(student);
	    }
	    @PostMapping("/login")
	    public ResponseEntity<?> loginStudent(@RequestBody Map<String, String> loginData) {
	        String email = loginData.get("email");
	        String password = loginData.get("password");

	        Student student = studentService.loginStudent(email, password);

	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }
	    }

	}


