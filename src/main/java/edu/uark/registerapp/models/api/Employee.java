package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.registerapp.models.entities.EmployeeEntity;

public class Employee extends ApiResponse {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	private int employeeId;
	public int getEmployeeId() {
		return this.employeeId;
	}
	public Employee setEmployeeId(final int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	private byte[] password;
	public byte[] getPassword() {
		return this.password;
	}
	public Employee setPassword(final byte[] password) {
		this.password = password;
		return this;
	}
	
	private boolean isActive;
	public boolean isActive() {
		return this.isActive;
	}
	public Employee setActive(final boolean active) {
		this.isActive = active;
		return this;
	}
	
	private int classification;
	public int getClassification() {
		return this.classification;
	}
	public Employee setClassification(final int classification) {
		this.classification = classification;
		return this;
	}
	
	private UUID managerId;
	public UUID getManagerId() {
		return this.managerId;
	}
	public Employee setManagerId(final UUID managerId) {
		this.managerId = managerId;
		return this;
	}
	
	private String createdOn;
	public String getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	public Employee setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn = createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return this;
	}
	
	public Employee() {
		super();
		
		this.id = new UUID(0, 0);
		this.employeeId = -1;
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.password = new byte[30];
		this.isActive = false;
		this.classification = -1;
		this.managerId = new UUID(0, 0);
		this.setCreatedOn(LocalDateTime.now());	
	}
	
	public Employee(final EmployeeEntity employeeEntity) {
		super(false);

		this.id = employeeEntity.getId();
		this.employeeId = employeeEntity.getEmployeeId();
		this.firstName = employeeEntity.getFirstName();
		this.lastName = employeeEntity.getLastName();
		this.password = employeeEntity.getPassword();
		this.isActive = employeeEntity.isActive();
		this.classification = employeeEntity.getClassification();
		this.managerId = employeeEntity.getManagerId();
		this.setCreatedOn(employeeEntity.getCreatedOn());
	}
	
}