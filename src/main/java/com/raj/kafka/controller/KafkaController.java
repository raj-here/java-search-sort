package com.raj.kafka.controller;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raj.kafka.MyTopicConsumer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	private KafkaTemplate<String, String> template;
	private MyTopicConsumer myTopicConsumer;

	public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer myTopicConsumer) {

		this.template = template;
		this.myTopicConsumer = myTopicConsumer;
	}

	@GetMapping("/kafka/produce")
	public void produce(@RequestParam String message) {
		template.send("myTopic2ss", message);

	}

	@GetMapping("/kafka/messages")
	public List<String> getMessages() {
		return myTopicConsumer.getMessages();

	}
}