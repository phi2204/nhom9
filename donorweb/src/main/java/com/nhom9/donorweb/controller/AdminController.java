package com.nhom9.donorweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom9.donorweb.model.Donations;
import com.nhom9.donorweb.model.Role;
import com.nhom9.donorweb.model.ToChuc;
import com.nhom9.donorweb.model.Topic;
import com.nhom9.donorweb.model.User;
import com.nhom9.donorweb.service.DonationsService;
import com.nhom9.donorweb.service.RoleService;
import com.nhom9.donorweb.service.ToChucService;
import com.nhom9.donorweb.service.TopicService;
import com.nhom9.donorweb.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private DonationsService donationsService;
	@Autowired
	private ToChucService toChucService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public String index(HttpServletRequest request, Model model) {
		if(checkauth(request)) {
			Integer total_donations = (donationsService.totalDonation()==null)?0:donationsService.totalDonation();
			Integer total_topics = (topicService.findAll()==null)?0:topicService.findAll().size();
			Integer total_accounts = (userService.findAll()==null)?0:userService.findAll().size();
			Integer total_orgs = (toChucService.findAll()==null)?0:toChucService.findAll().size();
			model.addAttribute("total_orgs",total_orgs);
			model.addAttribute("total_accounts",total_accounts);
			model.addAttribute("total_topics",total_topics);
			model.addAttribute("total_donations",total_donations);
			return "admin_page";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/donation")
	public String donation(HttpServletRequest request, Model model) {
		if(checkauth(request)) {
			List<Donations> donations = donationsService.findAll();
			model.addAttribute("donations",donations);
			return "admin_donation";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/topic")
	public String topic(HttpServletRequest request, Model model) {
		if(checkauth(request)) {
			List<Topic> topics = topicService.findAll();
			model.addAttribute("topics",topics);
			List<ToChuc> tochucs = toChucService.findAll();
			model.addAttribute("tochucs",tochucs);
			return "admin_topic";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/topicupdate")
	public String topicupdate(HttpServletRequest request, Model model, @RequestParam("id")Integer id) {
		if(checkauth(request)) {
			Topic topic = topicService.findTopicById(id);
			model.addAttribute("topic",topic);
			List<ToChuc> tochucs = toChucService.findAll();
			model.addAttribute("tochucs",tochucs);
			return "admin_updatetopic";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/organization")
	public String organization(HttpServletRequest request, Model model) {
		if(checkauth(request)) {
			List<ToChuc> toChucs = toChucService.findAll();
			model.addAttribute("tochucs",toChucs);
			return "admin_organization";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/organizationupdate")
	public String organizationupdate(HttpServletRequest request, Model model, @RequestParam("id")Integer id) {
		if(checkauth(request)) {
			ToChuc tochuc = toChucService.findToChucById(id);
			model.addAttribute("tochuc",tochuc);
			return "admin_updateorganization";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/user")
	public String user(HttpServletRequest request, Model model) {
		if(checkauth(request)) {
			List<User> users = userService.findAll();
			model.addAttribute("users",users);
			System.out.println(users.get(0).toString());
			List<Role> roles = roleService.findAll();
			model.addAttribute("roles",roles);
			return "admin_user";
		}
		return "redirect:/home/index";
	}
	
	@GetMapping("/userupdate")
	public String userupdate(HttpServletRequest request, Model model, @RequestParam("id")Integer id) {
		if(checkauth(request)) {
			User user = userService.findUserById(id);
			model.addAttribute("user",user);
			List<Role> roles = roleService.findAll();
			model.addAttribute("roles",roles);
			return "admin_updateuser";
		}
		return "redirect:/home/index";
	}
	
	public boolean checkauth(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		if(session.getAttribute("user_id") != null && session.getAttribute("role").equals("ADMIN")) {
			return true;
		}
		return false;
	}
}
