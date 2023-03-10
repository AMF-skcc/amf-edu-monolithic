package com.example.amf.edu.monolithic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.amf.edu.monolithic.domain.model.Admin;
import com.example.amf.edu.monolithic.service.AdminService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AdminRestController {
	private final AdminService adminService;

	@GetMapping("/hello")
	public String getTeamHello() {
		return "Welcome To AMF Team";
	}

    //admin 관리
	@GetMapping("/admins")
    public ResponseEntity<List<Admin>> selectAllAdmin() {
        List<Admin> admins = adminService.selectAllAdmin();
        return ResponseEntity.ok().body(admins);
    }

    //단일 admin 조회(필요x)
	@GetMapping("/admin/{adminId}")
    public ResponseEntity<Admin> selectAdminById(@PathVariable Long adminId) {
        Admin admin = adminService.selectAdminById(adminId);
        return ResponseEntity.ok().body(admin);
    }

    //admin 생성
    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok().body(savedAdmin);
    }
    //admin 변경
    @PutMapping("/admin/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable Long adminId) {
        Admin savedAdmin = adminService.updateAdmin(adminId, admin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    //admin 삭제
    @DeleteMapping("/admin/{adminId}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable Long adminId) {
        Boolean success = adminService.deleteAdmin(adminId);
        return ResponseEntity.ok().body(success);
    }
}
