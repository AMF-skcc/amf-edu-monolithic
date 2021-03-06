package com.example.amf.edu.monolithic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.model.Course;
import com.example.amf.edu.monolithic.domain.model.Subject;
import com.example.amf.edu.monolithic.domain.repository.CourseRepository;
import com.example.amf.edu.monolithic.service.CourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
	private final CourseRepository courseRepository;

	@Override
	public List<Course> selectAllCourse() {
		return courseRepository.selectAllCourse();
	}

	@Override
	public Course selectCourseById(Long id) {
		return courseRepository.selectCourseById(id);
	}

	@Override
	public List<Subject> selectAllSubjectByCourseId(Long id) {
		return courseRepository.selectAllSubjectByCourseId(id);
	}

	@Override
	public List<Attendance> selectAllAttendanceByCourseId(Long id) {
		return courseRepository.selectAllAttendanceByCourseId(id);
	}

}
