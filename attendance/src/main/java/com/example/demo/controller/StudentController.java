package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = studentService.getAllStudents();
		log.info("All Student's Details: " + list);
		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		Student entity = studentService.getStudentById(id);
		log.info("Student's Details by ID: " + entity);
		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteStudentById(@PathVariable("id") Integer id) throws RecordNotFoundException {
		studentService.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping("/attendance/{attendanceDate}")
	public ResponseEntity<List<Student>> detailsByDate(@PathVariable("attendanceDate") Date date) {
		List<Student> list = studentService.detailsByDate(date);
		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
