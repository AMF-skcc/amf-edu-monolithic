package com.example.amf.edu.monolithic.service;

import java.util.List;

import com.example.amf.edu.monolithic.domain.model.Admin;

public interface AdminService {
	Admin selectAdminByEmail(String email);
	Admin selectAdminById(Long id);
	List<Admin> selectAllAdmin();

    Admin createAdmin(Admin admin);

	Admin updateAdmin(Long adminId, Admin admin);

	Boolean deleteAdmin(Long adminId);

	Admin adminLogin(Admin qAdmin);
}
