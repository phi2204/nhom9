package com.nhom9.donorweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import com.nhom9.donorweb.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findUserByEmail(String email);
	
	@Transactional
	@Modifying
	void deleteUserByEmail(String email);
	
	@Transactional
	@Modifying
	void deleteUserById(Integer id);
	
	User findUserById(Integer id);
}
