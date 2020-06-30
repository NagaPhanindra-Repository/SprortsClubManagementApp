package com.RAVURI.SportsClubManagement.web;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.RAVURI.SportsClubManagement.model.Events;
import com.RAVURI.SportsClubManagement.model.User;
import com.RAVURI.SportsClubManagement.repository.EventRepository;

@Controller
public class MianController {
	
	private EventRepository eventRepository;
	
	
	
	public MianController(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv=new	ModelAndView();
		mv.setViewName("index");
	List<Events>	events=eventRepository.findAll();
	events.stream().sorted(Comparator.comparing(Events::getEventName)).collect(Collectors.toList());
		System.out.println(events.toString());
		mv.addObject("events",events);
		return mv;
	}

}
