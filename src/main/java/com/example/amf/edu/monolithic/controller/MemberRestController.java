package com.example.amf.edu.monolithic.controller;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.amf.edu.monolithic.domain.model.Member;
import com.example.amf.edu.monolithic.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MemberRestController {
	private final MemberService memberService;

	@GetMapping("/members")
    public ResponseEntity<List<Member>> selectAllMember() {
        List<Member> members = memberService.selectAllMember();
        return ResponseEntity.ok().body(members);
    }

	@GetMapping("/member/{memberId}")
    public ResponseEntity<Member> selectMemberById(@PathVariable Long memberId) {
        Member member = memberService.selectMemberById(memberId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.createMember(member);
        return ResponseEntity.ok().body(savedMember);
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @PathVariable Long memberId) {
        if (memberId == null || !memberId.equals(member.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Member savedMember = memberService.updateMember(memberId, member);
        return ResponseEntity.ok().body(savedMember);
    }

    @DeleteMapping("/member/{memberId}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable Long memberId) {
        Boolean success = memberService.deleteMember(memberId);
        return ResponseEntity.ok().body(success);
    }
}
