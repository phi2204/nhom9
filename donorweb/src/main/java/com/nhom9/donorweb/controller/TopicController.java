package com.nhom9.donorweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom9.donorweb.model.Topic;
import com.nhom9.donorweb.service.TopicService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private final TopicService topicService;
	
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@GetMapping("/all")
	public String getTopics(Model model) {
		List<Topic> topics = topicService.findAll();
		model.addAttribute("topics",topics);
		return "charifit/cause";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id")Integer id,Model model, HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		Topic topic = topicService.findTopicById(id);
		double percent = ((double)topic.getMoney_donor()/topic.getSo_tien()) * 100;
		session.setAttribute("percent", Math.round(percent));
		model.addAttribute("topic",topic);
//		model.addAttribute("percent",Math.round(percent));
		System.out.println(Math.round(percent));
		return "charifit/cause_details";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("topic")Topic topic) {
		topic.setMoney_donor(0);
		topicService.addTopic(topic);
		return "redirect:/admin/topic?successadd";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id")Integer id) {
		topicService.deleteTopicById(id);
		return "redirect:/admin/topic?successdelete";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("topic")Topic topic) {
		System.out.println(topic.getTochuc().getTen_tc());
		topicService.updateTopic(topic);
		return "redirect:/admin/topic?successupdate";
	}
}
