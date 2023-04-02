package com.nhom9.donorweb.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom9.donorweb.model.User;
import com.nhom9.donorweb.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private final UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public User userRegistation() {
		return new User();
	}
	
	@GetMapping("/registrationform")
	public String showRegistrationForm() {
		return "register";
	}
	
	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("user") User registation) {
        Base64.Encoder encoder = Base64.getEncoder();
        String pass= encoder.encodeToString(registation.getPassword().getBytes(StandardCharsets.UTF_8));
        registation.setPassword(pass);
		userService.addUser(registation);
		return "redirect:/user/registrationform?success";
	}
	
	@GetMapping("/loginform")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String auth(@RequestParam String email,@RequestParam String password,HttpServletRequest request) {
        Base64.Encoder encoder = Base64.getEncoder();
        String pass=encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        boolean user=userService.auth(email, pass,request);
        if(user)
			return "redirect:/home/index";
		else
			return "redirect:/user/loginform?error";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		userService.logout(request);
		return "redirect:/home/index";
	}
	
	public static boolean checkAuth(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		if(session.getAttribute("user_id") == null)
			return false;
		return true;
	}
	
	@PostMapping("/add")
	public String add(User user) {
		Base64.Encoder encoder = Base64.getEncoder();
		String pass= encoder.encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8));
		user.setPassword(pass);
		userService.addUser(user);
		return "redirect:/admin/user?successadd";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("user")User user) {
		userService.updateUser(user);
		return "redirect:/admin/user?successupdate";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id")Integer id) {
		try {
			userService.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/user?faildeletefore";
		}
		return "redirect:/admin/user?successdelete";
	}
}
