package com.example.amf.edu.monolithic.controller;

import com.example.amf.edu.monolithic.domain.model.Member;
import com.example.amf.edu.monolithic.service.MemberService;
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
    private final MemberService memberService;

    //관리자 로그인
    @PostMapping("/admin-login")
    public ResponseEntity<Admin> adminLogin(@RequestBody Admin pAdmin){
        Admin admin = adminService.adminLogin(pAdmin);
        return ResponseEntity.ok().body(admin);
    }
    @Deprecated
	@PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin pAdmin){
        Admin admin = adminService.selectAdminByEmail(pAdmin.getEmail());
        return ResponseEntity.ok().body(admin);
    }
    @PostMapping("/member-login")
    public ResponseEntity<Member> memberLogin(@RequestBody Member qMember){
        Member member = memberService.memberLogin(qMember);
        return ResponseEntity.ok().body(member);
    }
}
