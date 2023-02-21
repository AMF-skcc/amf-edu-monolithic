package com.example.amf.edu.monolithic.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.amf.edu.monolithic.domain.model.Admin;

@Mapper
@Repository
public interface AdminRepository {
	Admin selectAdminByEmail(String email);
	Admin selectAdminById(Long id);
	List<Admin> selectAllAdmin();

	Integer createAdmin(Admin admin);

	Integer updateAdmin(Long adminId, Admin admin);

	Integer deleteAdmin(Long adminId);
}
