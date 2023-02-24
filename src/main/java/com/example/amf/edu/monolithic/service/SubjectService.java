package com.example.amf.edu.monolithic.service;

import com.example.amf.edu.monolithic.domain.model.Subject;

import java.util.List;

public interface SubjectService {
	List<Subject> selectAllSubjects();
	Subject selectSubjectById(Long id);

    Subject createSubject(Subject subject);

	Subject updateSubject(Long subjectId, Subject subject);

	Boolean deleteSubject(Long subjectId);
}
