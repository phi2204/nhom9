package com.nhom9.donorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.nhom9.donorweb.model.ToChuc;

public interface ToChucRepo extends JpaRepository<ToChuc, Integer> {
	@Transactional
	@Modifying
	void deleteToChucById(Integer id);
	
	ToChuc findToChucById(Integer id);
}
