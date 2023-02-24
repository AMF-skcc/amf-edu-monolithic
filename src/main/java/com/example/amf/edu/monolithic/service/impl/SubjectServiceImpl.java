package com.example.amf.edu.monolithic.service.impl;

import com.example.amf.edu.monolithic.domain.model.Subject;
import com.example.amf.edu.monolithic.domain.repository.SubjectRepository;
import com.example.amf.edu.monolithic.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	private final SubjectRepository subjectRepository;

	@Override
	public List<Subject> selectAllSubjects() {
		return subjectRepository.selectAllSubject();
	}

	@Override
	public Subject selectSubjectById(Long id) {
		return subjectRepository.selectSubjectById(id);
	}

	@Override
	public Subject createSubject(Subject subject) {
		Integer result = subjectRepository.createSubject(subject);
		if (result == null || 0 == result) {
			return null;
		}
		return selectSubjectById(subject.getId());
	}

	@Override
	public Subject updateSubject(Long subjectId, Subject subject) {
		Integer result = subjectRepository.updateSubject(subjectId, subject);
		if (result == null || 0 == result) {
			return null;
		}
		return selectSubjectById(subject.getId());
	}

	@Override
	public Boolean deleteSubject(Long subjectId) {
		Integer result = subjectRepository.deleteSubject(subjectId);
		return result != null && 0 != result;
	}

}
