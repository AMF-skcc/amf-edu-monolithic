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

}
