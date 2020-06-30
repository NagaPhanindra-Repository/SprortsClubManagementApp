package com.RAVURI.SportsClubManagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.RAVURI.SportsClubManagement.model.User;
import com.RAVURI.SportsClubManagement.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService  {
	
	User save(UserRegistrationDto regestrationDto);

}
