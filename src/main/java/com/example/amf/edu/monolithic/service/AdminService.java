package com.example.amf.edu.monolithic.service;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Admin;

public interface AdminService {
	Admin selectAdminByEmail(String email);
	Admin selectAdminById(Long id);
	List<Admin> selectAllAdmin();
}
