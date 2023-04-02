package com.nhom9.donorweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.nhom9.donorweb.model.Topic;

public interface TopicRepo extends JpaRepository<Topic, Integer> {
	@Transactional
	@Modifying
	void deleteTopicById(Integer id);
	
	Topic findTopicById(Integer id);
}
