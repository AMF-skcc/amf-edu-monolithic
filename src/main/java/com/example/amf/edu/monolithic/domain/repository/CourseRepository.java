package com.example.amf.edu.monolithic.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.model.Course;
import com.example.amf.edu.monolithic.domain.model.Subject;

@Mapper
@Repository
public interface CourseRepository {
	List<Course> selectAllCourse();
	Course selectCourseById(Long id);
	List<Subject> selectAllSubjectByCourseId(Long id);
	List<Attendance> selectAllAttendanceByCourseId(Long id);

	Integer createCourse(Course course);
	Integer updateCourse(Long courseId, Course course);
	Integer deleteCourse(Long courseId);
}
