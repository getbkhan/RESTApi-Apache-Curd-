package com.example.springbootstarter.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring framework","Spring framework Discription"),
			new Topic("Hibernate","Hibernate Object Relational Mapping ","Hibernate Annotaitons"),
			new Topic("Collections","Collections framework","Collection types and Discription")
			));
	
	public List<Topic> getAllTopics()
	{
		//return topics;
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopicByIndex(String topicId) {
		//return topics.stream().filter(t ->t.getId().equals(topicId)).findFirst().get();
		return topicRepository.findById(topicId);
	}
	
	public void CreateNewTopic(Topic topic)
	{
		topicRepository.save(topic);
	}

	public void UpdateTopic(String id, Topic topic) {
		
		for(int i=0;i<topics.size();i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void DeleteThisTopics(String topicId) {
		topics.removeIf(t -> t.getId().equals(topicId));
	}
	

}
