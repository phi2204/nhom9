package com.nhom9.donorweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom9.donorweb.model.ToChuc;
import com.nhom9.donorweb.repository.ToChucRepo;

@Service
public class ToChucService {
	@Autowired
	private final ToChucRepo toChucRepo;

	public ToChucService(ToChucRepo toChucRepo) {
		this.toChucRepo = toChucRepo;
	}

	public List<ToChuc> findAll() {
		return toChucRepo.findAll();
	}

	public ToChuc addToChuc(ToChuc toChuc) {
		return toChucRepo.save(toChuc);
	}

	public ToChuc findToChucById(Integer id) {
		return toChucRepo.findToChucById(id);
	}

	public ToChuc updateToChuc(ToChuc toChuc) {
		return toChucRepo.save(toChuc);
	}

	public void deleteToChucById(Integer id) {
		toChucRepo.deleteToChucById(id);
	}
}
