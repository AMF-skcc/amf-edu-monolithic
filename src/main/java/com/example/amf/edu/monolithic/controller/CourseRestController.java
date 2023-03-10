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
    //모든 코스 리스트
	@GetMapping("/courses")
    public ResponseEntity<List<Course>> selectAllCourse() {
        List<Course> courses = courseService.selectAllCourse();
        return ResponseEntity.ok().body(courses);
    }
    // 코스 조회
	@GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> selectCourseById(@PathVariable Long courseId) {
        Course course = courseService.selectCourseById(courseId);
        return ResponseEntity.ok().body(course);
    }
    // 코스 생성
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.ok().body(savedCourse);
    }
    //코스 변경
    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long courseId) {
        Course savedCourse = courseService.updateCourse(courseId, course);
        return ResponseEntity.ok().body(savedCourse);
    }
    //코스 삭제
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable Long courseId) {
        Boolean success = courseService.deleteCourse(courseId);
        return ResponseEntity.ok().body(success);
    }
    //코스의 subject 조홰
	@GetMapping("/courses/{courseId}/subjects")
    public ResponseEntity<List<Subject>> selectAllSubjectByCourseId(@PathVariable Long courseId) {
        List<Subject> subjects = courseService.selectAllSubjectByCourseId(courseId);
        return ResponseEntity.ok().body(subjects);
    }
    //코스의 수강생 조회
	@GetMapping("/courses/{courseId}/attendances")
    public ResponseEntity<List<Attendance>> selectAllAttendanceByCourseId(@PathVariable Long courseId) {
		List<Attendance> attendances = courseService.selectAllAttendanceByCourseId(courseId);
        return ResponseEntity.ok().body(attendances);
    }
}
