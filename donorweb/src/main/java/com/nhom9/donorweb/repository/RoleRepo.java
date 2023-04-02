package com.nhom9.donorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.nhom9.donorweb.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	@Transactional
	@Modifying
	void deleteRoleById(Integer id);
	
	Role findRoleById(Integer id);
}
