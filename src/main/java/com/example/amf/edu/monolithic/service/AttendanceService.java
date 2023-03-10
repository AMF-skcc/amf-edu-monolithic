package com.example.amf.edu.monolithic.service;

import com.example.amf.edu.monolithic.domain.model.Attendance;

import java.util.List;

public interface AttendanceService {
	List<Attendance> selectAllAttendances();
	Attendance selectAttendanceById(Long id);

	List<Attendance> selectAttendanceByMemberId(Long memberId);

    Attendance createAttendance(Attendance attendance);

	Attendance updateAttendance(Long attendanceId, Attendance attendance);

	Boolean deleteAttendance(Long attendanceId);
}
