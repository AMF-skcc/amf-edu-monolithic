package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Subject;
import com.example.amf.edu.monolithic.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class SubjectRestController {
	private final SubjectService subjectService;

	@GetMapping("/subjects")
    public ResponseEntity<List<Subject>> selectAllSubjects() {
        List<Subject> members = subjectService.selectAllSubjects();
        return ResponseEntity.ok().body(members);
    }

	@GetMapping("/subjects/{subjectId}")
    public ResponseEntity<Subject> selectSubjectById(@PathVariable Long subjectId) {
        Subject member = subjectService.selectSubjectById(subjectId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.createSubject(subject);
        return ResponseEntity.ok().body(savedSubject);
    }

    @PutMapping("/subjects/{subjectId}")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject, @PathVariable Long subjectId) {
        if (subjectId == null || !subjectId.equals(subject.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Subject savedSubject = subjectService.updateSubject(subjectId, subject);
        return ResponseEntity.ok().body(savedSubject);
    }

    @DeleteMapping("/subjects/{subjectId}")
    public ResponseEntity<Boolean> deleteSubject(@PathVariable Long subjectId) {
        Boolean success = subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().body(success);
    }
}
