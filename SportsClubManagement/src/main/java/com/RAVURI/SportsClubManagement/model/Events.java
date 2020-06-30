package com.RAVURI.SportsClubManagement.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String eventName;
	private String contactNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
	private Date startTime;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
	private Date endTime;
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
	private LocalDateTime creationTime;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime() {
		
		this.creationTime = LocalDateTime.now();
	}
	
	
	
	

}
