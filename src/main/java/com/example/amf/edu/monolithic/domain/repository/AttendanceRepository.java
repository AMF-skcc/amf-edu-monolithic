package com.example.amf.edu.monolithic.domain.repository;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceRepository {
	List<Attendance> selectAllAttendance();
	Attendance selectAttendanceById(Long id);
	List<Attendance> selectAttendanceByMemberId(Long memberId);

    Integer createAttendance(Attendance attendance);

	Integer updateAttendance(Long attendanceId, Attendance attendance);

	Integer deleteAttendance(Long attendanceId);
}
