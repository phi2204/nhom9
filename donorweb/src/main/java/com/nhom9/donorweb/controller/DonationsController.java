package com.nhom9.donorweb.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom9.donorweb.model.Donations;
import com.nhom9.donorweb.model.Topic;
import com.nhom9.donorweb.service.DonationsService;
import com.nhom9.donorweb.service.TopicService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/donation")
public class DonationsController {
	@Autowired
	private final DonationsService donationsService;
	@Autowired
	private TopicService topicService;
	
	
	public DonationsController(DonationsService donationsService) {
		this.donationsService = donationsService;
	}
	
	@ModelAttribute("donation")
	public Donations donation() {
		return new Donations();
	}
	
	@GetMapping("/donationform")
	public String donationform(@RequestParam Long id, Model model, HttpServletRequest request) {
		if(!UserController.checkAuth(request))
			return "redirect:/user/loginform?login";
		model.addAttribute("topic_id",id);
		return "charifit/donation";
	}
	
	@PostMapping("/donate")
	public String donate(@RequestParam("credit_number1")String credit_number,@ModelAttribute("donation") Donations donations) {
		donations.setCredit_number(Integer.parseInt(credit_number));
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		donations.setNgay_tao(timeStamp);
		donationsService.addDonations(donations);
		Topic topic = topicService.findTopicById(donations.getTopic().getId());
		Integer total = topic.getMoney_donor() + donations.getSo_tien();
		topic.setMoney_donor(total);
		topicService.updateTopic(topic);
		return "redirect:/donation/donationform?id="+donations.getTopic().getId()+"&success";
	}
}
