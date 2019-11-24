package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Attendance;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = LoggerFactory.getLogger(StudentService.class);

	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();

		if (studentList.size() > 0) {
			return studentList;
		} else {
			return new ArrayList<Student>();
		}
	}

	public Student getStudentById(Integer id) throws RecordNotFoundException {
		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

	public void deleteStudentById(Integer id) throws RecordNotFoundException {
		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			studentRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public List<Student> detailsByDate(Date date) {
		List<Student> studentList = studentRepository.findAll();
		List<Student> studentListByDate = new ArrayList<>();
		studentList.forEach(student -> {
			List<Attendance> attendanceList = student.getAttendance();
			List<Attendance> attendanceListByDate = new ArrayList<>();
			attendanceList.forEach(attendance -> {
				log.info("Student ID: " + student.getId());
				log.info("Student ID through attendance object: " + attendance.getStudentId());
				if (attendance.getAttendanceDate().equals(date) && student.getId().equals(attendance.getStudentId())) {
					log.info("Attendance Object: " + attendance);
					attendanceListByDate.add(attendance);
					log.info("Attendance List: " + attendanceListByDate);
					student.setAttendance(attendanceListByDate);
					log.info("Student object: " + student);
				}
			});
			studentListByDate.add(student);
			log.info("Student List: " + studentListByDate);
		});
		return studentListByDate;
	}
}