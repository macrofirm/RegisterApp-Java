package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.entities.ActiveUserEntity;

public class ActiveUser extends ApiResponse{
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public ActiveUser setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	private int employeeId;
	public int getEmployeeId() {
		return this.employeeId;
	}
	public ActiveUser setEmployeeId(final int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private String name;
	public String getName() {
		return this.name;
	}
	public ActiveUser setName(final String name) {
		this.name = name;
		return this;
	}
	
	private int classification;
	public int getClassification() {
		return this.classification;
	}
	public ActiveUser setClassification(final int classification) {
		this.classification = classification;
		return this;
	}
	
	private String sessionKey;
	public String getSessionKey() {
		return this.sessionKey;
	}
	public ActiveUser setSessionKey(final String sessionKey) {
		this.sessionKey = sessionKey;
		return this;
	}
	
	private String createdOn;
	public String getCreatedOn() {
		return this.createdOn;
	}
	public ActiveUser setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public ActiveUser setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn = createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return this;
	}
	
	public ActiveUser() {
		super();
		
		this.id = new UUID(0, 0);
		this.employeeId = 0;
		this.name = StringUtils.EMPTY;
		this.classification = 0;
		this.sessionKey = StringUtils.EMPTY;
		this.setCreatedOn(LocalDateTime.now());
	}
	
	public ActiveUser(final ActiveUserEntity activeUserEntity) {
		super(false);
		
		this.id = activeUserEntity.getId();
		this.employeeId = activeUserEntity.getEmployeeId();
		this.name = activeUserEntity.getName();
		this.classification = activeUserEntity.getClassification();
		this.sessionKey = activeUserEntity.getSessionKey();
		this.setCreatedOn(activeUserEntity.getCreatedOn());
	}
	
}
