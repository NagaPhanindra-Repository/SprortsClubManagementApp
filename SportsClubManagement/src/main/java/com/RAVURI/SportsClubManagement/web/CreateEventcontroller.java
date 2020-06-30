package com.RAVURI.SportsClubManagement.web;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.RAVURI.SportsClubManagement.model.Events;
import com.RAVURI.SportsClubManagement.repository.EventRepository;
import com.RAVURI.SportsClubManagement.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/createevent")
public class CreateEventcontroller {
	
	private EventRepository eventRepository;

	public CreateEventcontroller(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}
	@GetMapping
	public String showEventForm() {
		return "createevent";
	}
	
	@ModelAttribute("event")
    public com.RAVURI.SportsClubManagement.web.dto.eventDto eventDto() {
        return new com.RAVURI.SportsClubManagement.web.dto.eventDto();
    }
	
   
	@PostMapping
	public String saveEvent(@ModelAttribute("event") com.RAVURI.SportsClubManagement.web.dto.eventDto eventDto) {
		Events event=new Events();
		event.setContactNumber(eventDto.getContactNumber());;
		event.setEventName(eventDto.getEventName());
		event.setStartTime(eventDto.getStartTime());
		event.setEndTime(eventDto.getEndTime());
		
		eventRepository.save(event);
		return "redirect:/createevent?success";
	}
	
}
