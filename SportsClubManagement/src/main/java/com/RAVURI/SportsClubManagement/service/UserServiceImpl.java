package com.RAVURI.SportsClubManagement.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.RAVURI.SportsClubManagement.model.Role;
import com.RAVURI.SportsClubManagement.model.User;
import com.RAVURI.SportsClubManagement.repository.UserRepository;
import com.RAVURI.SportsClubManagement.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private BCryptPasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	@Override
	public User save(UserRegistrationDto regestrationDto) {
		User user=new User(regestrationDto.getFirstName(),
				regestrationDto.getLastName(),
				regestrationDto.getEmail(),
				passwordEncoder.encode(regestrationDto.getPassword()),
				Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
		
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		 
		
	}

}
