package com.example.amf.edu.monolithic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.amf.edu.monolithic.domain.model.Admin;
import com.example.amf.edu.monolithic.domain.repository.AdminRepository;
import com.example.amf.edu.monolithic.service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	private final AdminRepository adminRepository;

	@Override
	public Admin selectAdminByEmail(String email) {
		return adminRepository.selectAdminByEmail(email);
	}

	@Override
	public Admin selectAdminById(Long id) {
		return adminRepository.selectAdminById(id);
	}

	@Override
	public List<Admin> selectAllAdmin() {
		return adminRepository.selectAllAdmin();
	}

	@Override
	public Admin createAdmin(Admin admin) {
		Integer result = adminRepository.createAdmin(admin);
		if (result == null || 0 == result) {
			return null;
		}
		return selectAdminById(admin.getId());
	}

	@Override
	public Admin updateAdmin(Long adminId, Admin admin) {
		Integer result = adminRepository.updateAdmin(adminId, admin);
		if (result == null || 0 == result) {
			return null;
		}
		return selectAdminById(admin.getId());
	}

	@Override
	public Boolean deleteAdmin(Long adminId) {
		Integer result = adminRepository.deleteAdmin(adminId);
		return result != null && 0 != result;
	}

	@Override
	public Admin adminLogin(Admin qAdmin){

		Admin admin = selectAdminByEmail(qAdmin.getEmail());

		if(!qAdmin.getPassword().equals(admin.getPassword())){
			throw new RuntimeException("로그인 실패");
		}
		admin.erasePassword();
		return admin;

	}

}
