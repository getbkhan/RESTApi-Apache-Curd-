package com.example.springbootstarter.topic;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	 
	@RequestMapping("/topics/{topicId}")
	public Optional<Topic> GetTopic(@PathVariable String topicId)
	{
		return topicService.getTopicByIndex(topicId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public String PostTopic(@RequestBody Topic topic)
	{
		topicService.CreateNewTopic(topic);
		return "topic Added in list";
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String UpdateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicService.UpdateTopic(id,topic);
		return "topic Update in list";
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}")
	public String DeleteTopic(@PathVariable String topicId)
	{
		topicService.DeleteThisTopics(topicId);
		return "Topic Deleted";
	}
	

}
