package com.nhom9.donorweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nhom9.donorweb.model.Donations;

public interface DonationsRepo extends JpaRepository<Donations, Integer> {
	@Transactional
	@Modifying
	void deleteDonationsById(Integer id);
	
	Donations findDonationsById(Integer id);
	
	@Query(value = "SELECT SUM(so_tien) "
			+ "FROM donations ",
			nativeQuery = true)
	Integer totalDonations();
}
