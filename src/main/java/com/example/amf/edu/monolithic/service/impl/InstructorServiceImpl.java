package com.example.amf.edu.monolithic.service.impl;

import com.example.amf.edu.monolithic.domain.model.Instructor;
import com.example.amf.edu.monolithic.domain.repository.InstructorRepository;
import com.example.amf.edu.monolithic.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService {
	private final InstructorRepository instructorRepository;

	@Override
	public List<Instructor> selectAllInstructors() {
		return instructorRepository.selectAllInstructor();
	}

	@Override
	public Instructor selectInstructorById(Long id) {
		return instructorRepository.selectInstructorById(id);
	}

	@Override
	public Instructor createInstructor(Instructor instructor) {
		Integer result = instructorRepository.createInstructor(instructor);
		if (result == null || 0 == result) {
			return null;
		}
		return selectInstructorById(instructor.getId());
	}

	@Override
	public Instructor updateInstructor(Long instructorId, Instructor instructor) {
		Integer result = instructorRepository.updateInstructor(instructorId, instructor);
		if (result == null || 0 == result) {
			return null;
		}
		return selectInstructorById(instructor.getId());
	}

	@Override
	public Boolean deleteInstructor(Long instructorId) {
		Integer result = instructorRepository.deleteInstructor(instructorId);
		return result != null && 0 != result;
	}

}
