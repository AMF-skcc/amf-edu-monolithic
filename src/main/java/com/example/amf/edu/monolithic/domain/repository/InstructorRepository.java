package com.example.amf.edu.monolithic.domain.repository;

import com.example.amf.edu.monolithic.domain.model.Instructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InstructorRepository {
	List<Instructor> selectAllInstructor();
	Instructor selectInstructorById(Long id);

    Integer createInstructor(Instructor instructor);

	Integer updateInstructor(Long instructorId, Instructor instructor);

	Integer deleteInstructor(Long instructorId);
}
