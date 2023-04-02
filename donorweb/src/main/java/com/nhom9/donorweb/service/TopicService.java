package com.nhom9.donorweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom9.donorweb.model.Topic;
import com.nhom9.donorweb.repository.TopicRepo;

@Service
public class TopicService {
	@Autowired
	private final TopicRepo topicRepo;
	
	
	public TopicService(TopicRepo topicRepo) {
		this.topicRepo = topicRepo;
	}
	
	public List<Topic> findAll(){
		return topicRepo.findAll();
	}
	
	public Topic addTopic(Topic topic) {
		return topicRepo.save(topic);
	}
	
	public Topic findTopicById(Integer id) {
		return topicRepo.findTopicById(id);
	}
	
	public Topic updateTopic(Topic topic) {
		return topicRepo.save(topic);
	}
	
	public void deleteTopicById(Integer id) {
		topicRepo.deleteTopicById(id);
	}
}
