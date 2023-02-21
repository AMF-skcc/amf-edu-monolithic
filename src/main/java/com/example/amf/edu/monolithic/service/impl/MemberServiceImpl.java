package com.example.amf.edu.monolithic.service.impl;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Member;
import org.springframework.stereotype.Service;

import com.example.amf.edu.monolithic.domain.model.Member;
import com.example.amf.edu.monolithic.domain.repository.MemberRepository;
import com.example.amf.edu.monolithic.service.MemberService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public List<Member> selectAllMember() {
		return memberRepository.selectAllMember();
	}

	@Override
	public Member selectMemberById(Long id) {
		return memberRepository.selectMemberById(id);
	}

	@Override
	public Member createMember(Member member) {
		Integer result = memberRepository.createMember(member);
		if (result == null || 0 == result) {
			return null;
		}
		return selectMemberById(member.getId());
	}

	@Override
	public Member updateMember(Long memberId, Member member) {
		Integer result = memberRepository.updateMember(memberId, member);
		if (result == null || 0 == result) {
			return null;
		}
		return selectMemberById(member.getId());
	}

	@Override
	public Boolean deleteMember(Long memberId) {
		Integer result = memberRepository.deleteMember(memberId);
		return result != null && 0 != result;
	}

}
