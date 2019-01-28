package com.mujahidk.vessel.titan.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class TimedInfo {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(nullable = false)
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	
	@Column(nullable = false)
	private LocalDateTime event;
	
	protected TimedInfo() {
	}

	public TimedInfo(String description, LocalDateTime event) {
		this.description = description;
		this.event = event;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEvent() {
		return event;
	}

	public void setEvent(LocalDateTime event) {
		this.event = event;
	}
}
