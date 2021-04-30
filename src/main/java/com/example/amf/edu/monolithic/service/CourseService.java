package com.example.amf.edu.monolithic.service;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.model.Course;
import com.example.amf.edu.monolithic.domain.model.Subject;

public interface CourseService {
	List<Course> selectAllCourse();
	Course selectCourseById(Long id);
	List<Subject> selectAllSubjectByCourseId(Long id);
	List<Attendance> selectAllAttendanceByCourseId(Long id);
}
