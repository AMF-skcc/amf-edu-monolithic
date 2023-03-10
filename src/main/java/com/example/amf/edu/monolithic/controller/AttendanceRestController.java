package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Attendance;
import com.example.amf.edu.monolithic.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AttendanceRestController {
	private final AttendanceService attendanceService;

    //모든 수강 확인(팔요x)
	@GetMapping("/attendances")
    public ResponseEntity<List<Attendance>> selectAllAttendances() {
        List<Attendance> members = attendanceService.selectAllAttendances();
        return ResponseEntity.ok().body(members);
    }
    //특정 멤버 수강 확인
	@GetMapping("/attendances/member/{memberId}")
    public ResponseEntity<List<Attendance>> selectAttendanceById(@PathVariable Long memberId) {
        List<Attendance> member = attendanceService.selectAttendanceByMemberId(memberId);
        return ResponseEntity.ok().body(member);
    }
    // 수강신청
    @PostMapping("/attendances")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.createAttendance(attendance);
        return ResponseEntity.ok().body(savedAttendance);
    }
    //수강 변경(필요 x)
    @PutMapping("/attendances/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance, @PathVariable Long attendanceId) {
        if (attendanceId == null || !attendanceId.equals(attendance.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Attendance savedAttendance = attendanceService.updateAttendance(attendanceId, attendance);
        return ResponseEntity.ok().body(savedAttendance);
    }
    //수강 취소
    @DeleteMapping("/attendances/{attendanceId}")
    public ResponseEntity<Boolean> deleteAttendance(@PathVariable Long attendanceId) {
        Boolean success = attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.ok().body(success);
    }
}
