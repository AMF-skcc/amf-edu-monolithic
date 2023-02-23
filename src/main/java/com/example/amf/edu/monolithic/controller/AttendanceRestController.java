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

	@GetMapping("/attendances")
    public ResponseEntity<List<Attendance>> selectAllAttendances() {
        List<Attendance> members = attendanceService.selectAllAttendances();
        return ResponseEntity.ok().body(members);
    }

	@GetMapping("/attendances/{memberId}")
    public ResponseEntity<Attendance> selectAttendanceById(@PathVariable Long memberId) {
        Attendance member = attendanceService.selectAttendanceById(memberId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/attendances")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.createAttendance(attendance);
        return ResponseEntity.ok().body(savedAttendance);
    }

    @PutMapping("/attendances/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance, @PathVariable Long attendanceId) {
        if (attendanceId == null || !attendanceId.equals(attendance.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Attendance savedAttendance = attendanceService.updateAttendance(attendanceId, attendance);
        return ResponseEntity.ok().body(savedAttendance);
    }

    @DeleteMapping("/attendances/{attendanceId}")
    public ResponseEntity<Boolean> deleteAttendance(@PathVariable Long attendanceId) {
        Boolean success = attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.ok().body(success);
    }
}
