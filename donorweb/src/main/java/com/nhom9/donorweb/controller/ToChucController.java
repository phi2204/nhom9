package com.nhom9.donorweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom9.donorweb.model.ToChuc;
import com.nhom9.donorweb.service.ToChucService;

@Controller
@RequestMapping("/tochuc")
public class ToChucController {
	@Autowired
	private final ToChucService toChucService;
	
	
	public ToChucController(ToChucService toChucService) {
		this.toChucService = toChucService;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("tochuc")ToChuc tochuc) {
		toChucService.updateToChuc(tochuc);
		return "redirect:/admin/organization?successupdate";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id")Integer id) {
		try {
			toChucService.deleteToChucById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/organization?faildeleteforeg";
		}
		return "redirect:/admin/organization?successdelete";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("tochuc")ToChuc tochuc) {
		toChucService.addToChuc(tochuc);
		return "redirect:/admin/organization?successadd";
	}
}
