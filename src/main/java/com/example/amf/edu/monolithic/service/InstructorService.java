package com.example.amf.edu.monolithic.service;

import com.example.amf.edu.monolithic.domain.model.Instructor;

import java.util.List;

public interface InstructorService {
	List<Instructor> selectAllInstructors();
	Instructor selectInstructorById(Long id);

    Instructor createInstructor(Instructor instructor);

	Instructor updateInstructor(Long instructorId, Instructor instructor);

	Boolean deleteInstructor(Long instructorId);
}
