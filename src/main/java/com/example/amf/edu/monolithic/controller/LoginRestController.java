package com.example.amf.edu.monolithic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amf.edu.monolithic.domain.model.Admin;
import com.example.amf.edu.monolithic.service.AdminService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class LoginRestController {
	private final AdminService adminService;
	
	@PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin pAdmin){
        Admin admin = adminService.selectAdminByEmail(pAdmin.getEmail());
        return ResponseEntity.ok().body(admin);
    }
}
