package com.example.amf.edu.monolithic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amf.edu.monolithic.domain.model.Member;
import com.example.amf.edu.monolithic.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MemberRestController {
	private final MemberService memberService;
	
	@GetMapping("/members")
    public ResponseEntity<List<Member>> selectAllAdmin() {
        List<Member> members = memberService.selectAllMember();
        return ResponseEntity.ok().body(members);
    }
	
	@GetMapping("/member/{memberId}")
    public ResponseEntity<Member> selectAdminById(@PathVariable Long memberId) {
        Member member = memberService.selectMemberById(memberId);
        return ResponseEntity.ok().body(member);
    }
}
