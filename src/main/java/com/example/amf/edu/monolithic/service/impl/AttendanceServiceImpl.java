package com.example.amf.edu.monolithic.service.impl;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.domain.repository.AttendanceRepository;
import com.example.amf.edu.monolithic.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
	private final AttendanceRepository attendanceRepository;

	@Override
	public List<Attendance> selectAllAttendances() {
		return attendanceRepository.selectAllAttendance();
	}

	@Override
	public Attendance selectAttendanceById(Long id) {
		return attendanceRepository.selectAttendanceById(id);
	}

	@Override
	public Attendance createAttendance(Attendance attendance) {
		Integer result = attendanceRepository.createAttendance(attendance);
		if (result == null || 0 == result) {
			return null;
		}
		return selectAttendanceById(attendance.getId());
	}

	@Override
	public Attendance updateAttendance(Long attendanceId, Attendance attendance) {
		Integer result = attendanceRepository.updateAttendance(attendanceId, attendance);
		if (result == null || 0 == result) {
			return null;
		}
		return selectAttendanceById(attendance.getId());
	}

	@Override
	public Boolean deleteAttendance(Long attendanceId) {
		Integer result = attendanceRepository.deleteAttendance(attendanceId);
		return result != null && 0 != result;
	}

}
