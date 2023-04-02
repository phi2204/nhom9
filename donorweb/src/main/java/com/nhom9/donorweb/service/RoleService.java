package com.nhom9.donorweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom9.donorweb.model.Role;
import com.nhom9.donorweb.repository.RoleRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService {
	@Autowired
	public RoleRepo roleRepo;
	
	public RoleService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	public Role addRole(Role role) {
		return roleRepo.save(role);
	}

	public Role findRoleById(Integer id) {
		return roleRepo.findRoleById(id);
	}

	public Role updateRole(Role role) {
		return roleRepo.save(role);
	}

	public void deleteRoleById(Integer id) {
		roleRepo.deleteRoleById(id);
	}
}
