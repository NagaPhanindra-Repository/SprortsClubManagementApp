package com.RAVURI.SportsClubManagement.web.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class eventDto {
	private String eventName;
	private String contactNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
	private Date startTime;
	@DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
	private Date endTime;
	   
	
	public eventDto(){
		
	}
	public eventDto(String eventName, String contactNumber,Date startTime,Date endTime) {
		super();
		this.eventName = eventName;
		this.contactNumber = contactNumber;
		this.startTime=startTime;
		this.endTime=endTime;
		
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
	
	
	

}
