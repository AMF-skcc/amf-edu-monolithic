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

	@GetMapping("/admins")
    public ResponseEntity<List<Admin>> selectAllAdmin() {
        List<Admin> admins = adminService.selectAllAdmin();
        return ResponseEntity.ok().body(admins);
    }

	@GetMapping("/admin/{adminId}")
    public ResponseEntity<Admin> selectAdminById(@PathVariable Long adminId) {
        Admin admin = adminService.selectAdminById(adminId);
        return ResponseEntity.ok().body(admin);
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    @PutMapping("/admin/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable Long adminId) {
        Admin savedAdmin = adminService.updateAdmin(adminId, admin);
        return ResponseEntity.ok().body(savedAdmin);
    }

    @DeleteMapping("/admin/{adminId}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable Long adminId) {
        Boolean success = adminService.deleteAdmin(adminId);
        return ResponseEntity.ok().body(success);
    }
}
