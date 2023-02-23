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

	@GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> selectAllInstructors() {
        List<Instructor> members = instructorService.selectAllInstructors();
        return ResponseEntity.ok().body(members);
    }

	@GetMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> selectInstructorById(@PathVariable Long instructorId) {
        Instructor member = instructorService.selectInstructorById(instructorId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/instructors")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.ok().body(savedInstructor);
    }

    @PutMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, @PathVariable Long instructorId) {
        if (instructorId == null || !instructorId.equals(instructor.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Instructor savedInstructor = instructorService.updateInstructor(instructorId, instructor);
        return ResponseEntity.ok().body(savedInstructor);
    }

    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<Boolean> deleteInstructor(@PathVariable Long instructorId) {
        Boolean success = instructorService.deleteInstructor(instructorId);
        return ResponseEntity.ok().body(success);
    }
}
