package com.example.amf.edu.monolithic.service;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Member;

public interface MemberService {
	List<Member> selectAllMember();
	Member selectMemberById(Long id);
}
