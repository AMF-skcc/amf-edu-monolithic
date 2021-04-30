package com.example.amf.edu.monolithic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
