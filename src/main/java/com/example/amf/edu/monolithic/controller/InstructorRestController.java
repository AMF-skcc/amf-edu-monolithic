package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Instructor;
import com.example.amf.edu.monolithic.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class InstructorRestController {
	private final InstructorService instructorService;
    //강사 리스트 조회
	@GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> selectAllInstructors() {
        List<Instructor> members = instructorService.selectAllInstructors();
        return ResponseEntity.ok().body(members);
    }
    //강사 조회 (필요 x)
	@GetMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> selectInstructorById(@PathVariable Long instructorId) {
        Instructor member = instructorService.selectInstructorById(instructorId);
        return ResponseEntity.ok().body(member);
    }
    //강사 등록
    @PostMapping("/instructors")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.ok().body(savedInstructor);
    }
    //강사 변경 (필요 X)
    @PutMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, @PathVariable Long instructorId) {
        if (instructorId == null || !instructorId.equals(instructor.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Instructor savedInstructor = instructorService.updateInstructor(instructorId, instructor);
        return ResponseEntity.ok().body(savedInstructor);
    }
    //강사 삭제
    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<Boolean> deleteInstructor(@PathVariable Long instructorId) {
        Boolean success = instructorService.deleteInstructor(instructorId);
        return ResponseEntity.ok().body(success);
    }
}
