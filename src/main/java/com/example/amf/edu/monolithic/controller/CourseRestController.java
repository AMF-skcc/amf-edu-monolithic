package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.model.Course;
import com.example.amf.edu.monolithic.domain.model.Subject;
import com.example.amf.edu.monolithic.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.ok().body(savedCourse);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long courseId) {
        Course savedCourse = courseService.updateCourse(courseId, course);
        return ResponseEntity.ok().body(savedCourse);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Long courseId) {
        Boolean success = courseService.deleteCourse(courseId);
        return ResponseEntity.ok().body(success);
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
