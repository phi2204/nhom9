package com.nhom9.donorweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom9.donorweb.model.Donations;
import com.nhom9.donorweb.repository.DonationsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DonationsService {
	@Autowired
	private final DonationsRepo donationsRepo;
	
	public DonationsService(DonationsRepo donationsRepo) {
		this.donationsRepo = donationsRepo;
	}
	
	public List<Donations> findAll() {
		return donationsRepo.findAll();
	}

	public Donations addDonations(Donations donations) {
		return donationsRepo.save(donations);
	}

	public Donations findDonationsById(Integer id) {
		return donationsRepo.findDonationsById(id);
	}

	public Donations updateDonations(Donations donations) {
		return donationsRepo.save(donations);
	}

	public void deleteDonationsById(Integer id) {
		donationsRepo.deleteDonationsById(id);
	}
	
	public Integer totalDonation() {
		return donationsRepo.totalDonations();
	}
}
