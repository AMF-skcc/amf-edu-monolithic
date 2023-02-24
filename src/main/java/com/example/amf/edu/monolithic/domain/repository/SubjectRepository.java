package com.example.amf.edu.monolithic.domain.repository;

import com.example.amf.edu.monolithic.domain.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectRepository {
	List<Subject> selectAllSubject();
	Subject selectSubjectById(Long id);

    Integer createSubject(Subject subject);

	Integer updateSubject(Long subjectId, Subject subject);

	Integer deleteSubject(Long subjectId);
}
