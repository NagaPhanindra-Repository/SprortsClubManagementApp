package com.RAVURI.SportsClubManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RAVURI.SportsClubManagement.model.Events;

public interface EventRepository extends JpaRepository<Events, Long> {

	

}
