package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Integer attendanceId;

	@Column(name = "lecture_no")
	private Integer lectureNo;

	@Column(name = "lecture_name")
	private String lectureName;

	@Column(name = "attendance_date")
	private Date attendanceDate;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	public Attendance() {
	}

	public Attendance(Integer attendanceId, Integer lectureNo, String lectureName, Date attendanceDate) {
		super();
		this.attendanceId = attendanceId;
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.attendanceDate = attendanceDate;
	}

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Integer getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(Integer lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	
	public Integer getStudentId() {
		return student.getId();
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", lectureNo=" + lectureNo + ", lectureName=" + lectureName
				+ ", attendanceDate=" + attendanceDate + "]";
	}
}