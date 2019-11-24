package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "select * from student s, attendance a where s.id = a.student_id and a.attendance_date = : date", nativeQuery = true)
	public List<Student> detailsByDate(Date date);
}