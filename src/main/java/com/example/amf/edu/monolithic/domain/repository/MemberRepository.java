package com.example.amf.edu.monolithic.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.amf.edu.monolithic.domain.model.Member;

@Mapper
@Repository
public interface MemberRepository {
	List<Member> selectAllMember();
	Member selectMemberById(Long id);
}