package com.example.amf.edu.monolithic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.model.Course;
import com.example.amf.edu.monolithic.domain.model.Subject;
import com.example.amf.edu.monolithic.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CourseRestController {
	private final CourseService courseService;
	
	@GetMapping("/courses")
    public ResponseEntity<List<Course>> selectAllCourse() {
        List<Course> courses = courseService.selectAllCourse();
        return ResponseEntity.ok().body(courses);
    }
	
	@GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> selectCourseById(@PathVariable Long courseId) {
        Course course = courseService.selectCourseById(courseId);
        return ResponseEntity.ok().body(course);
    }
	
	@GetMapping("/courses/{courseId}/subjects")
    public ResponseEntity<List<Subject>> selectAllSubjectByCourseId(@PathVariable Long courseId) {
        List<Subject> subjects = courseService.selectAllSubjectByCourseId(courseId);
        return ResponseEntity.ok().body(subjects);
    }
	
	@GetMapping("/courses/{courseId}/attendances")
    public ResponseEntity<List<Attendance>> selectAllAttendanceByCourseId(@PathVariable Long courseId) {
		List<Attendance> attendances = courseService.selectAllAttendanceByCourseId(courseId);
        return ResponseEntity.ok().body(attendances);
    }
}
