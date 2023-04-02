package com.nhom9.donorweb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom9.donorweb.model.Role;
import com.nhom9.donorweb.model.User;
import com.nhom9.donorweb.repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	private final UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public User addUser(User user) {
		if(user.getRole()==null)
			user.setRole(new Role(1,"USER"));
		return userRepo.save(user);
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User findUserByEmail(String email){
		return userRepo.findUserByEmail(email);
	}
	
	public User findUserById(Integer id){
		return userRepo.findUserById(id);
	}
	
	public void delete(String email) {
		userRepo.deleteUserByEmail(email);
	}
	
	public void deleteUserById(Integer id) {
		userRepo.deleteUserById(id);;
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	//login
		public boolean auth(String email, String password,HttpServletRequest request) {		

			//creating session variable

			HttpSession session=request.getSession(true);
			for (User user:userRepo.findAll()) {
				String myEmail=user.getEmail();
				String myPassword=user.getPassword();
				if(myEmail.toString().equals(email) && myPassword.toString().equals(password)) {	
		            session.setAttribute("user_id",user.getId());
		            session.setAttribute("user_name",user.getHo_ten());
		            session.setAttribute("user_email",user.getEmail());
		            session.setAttribute("role",user.getRole().getTen_role());
					return true;
				}
					
			}
	        session.setAttribute("error","Invalid email or password");
			return false;
		}
		
		public void logout(HttpServletRequest request) {
			HttpSession session=request.getSession(true);
			if(session.getAttribute("user_id") != null) {			
	            session.invalidate();
			}
		}
}
