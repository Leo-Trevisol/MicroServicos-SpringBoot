package com.leo.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.greetingservice.configuration.GreetingConfiguration;
import com.leo.greetingservice.model.Greetings;

@RestController
public class GreetingsController {
	
	private static final String template = "%s, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingConfiguration greetingConfiguration;
	
	@RequestMapping("/greetings")
	public Greetings greetings(@RequestParam(value = "name", defaultValue = "") String name) {
		
		if(name.isEmpty()) {
			name = greetingConfiguration.getDefaultValue();
		}
		
		return new Greetings(counter.incrementAndGet(), String.format(template, greetingConfiguration.getGreeting(),name)); 
		
		
	}

}
