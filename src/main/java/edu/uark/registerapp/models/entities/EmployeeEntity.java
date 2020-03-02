package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.models.api.Employee;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
		private final UUID id;

			public UUID getId() {
				return this.id;
			}

	@Column(name = "employeeid")
		private int employeeId;

			public int getEmployeeId() {
				return this.employeeId;
			}
	
			public EmployeeEntity setEmployeeId(final int employeeId) {
				this.employeeId = employeeId;
				return this;
			}

	@Column(name = "firstname")
		private String firstName;

			public String getFirstName() {
				return this.firstName;
			}
	
			public EmployeeEntity setFirstName(final String firstName) {
				this.firstName = firstName;
				return this;
			}

	@Column(name = "lastname")
		private String lastName;

			public String getLastName() {
				return this.lastName;
			}

			public EmployeeEntity setLastName(final String lastName) {
				this.lastName = lastName;
				return this;
			}

	@Column(name = "password")
		private byte[] password;
	
			public byte[] getPassword() {
				return this.password;
			}
			
			public EmployeeEntity setPassword(final byte[] password) {
				this.password = password;
				return this;
			}

	@Column(name = "active")
		private boolean active;
	
			public boolean isActive() {
				return this.active;
			}
			
			public EmployeeEntity setActive(final boolean active) {
				this.active = active;
				return this;
			}

	@Column(name = "classification")
		private int classification;
			
			public int getClassification() {
				return this.classification;
			}

			public EmployeeEntity setClassification(final int classification) {
				this.classification = classification;
				return this;
			}
			
	@Column(name = "managerid")
		private UUID managerId;
	
			public UUID getManagerId() {
				return this.managerId;
			}
			
			public EmployeeEntity setManagerId(final UUID managerId) {
				this.managerId = managerId;
				return this;
			}
			
	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
		private LocalDateTime createdOn;

			public LocalDateTime getCreatedOn() {
				return this.createdOn;
			}
			
	public Employee synchronize(final Employee apiEmployee) {
		this.setEmployeeId(apiEmployee.getEmployeeId());
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setPassword(apiEmployee.getPassword());
		this.setActive(apiEmployee.isActive());
		this.setClassification(apiEmployee.getClassification());
		this.setManagerId(apiEmployee.getManagerId());
		
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		
		return apiEmployee;
	}
			
	public EmployeeEntity() {
		this.id = new UUID(0, 0);
		this.employeeId = 0;
		this.firstName = StringUtils.EMPTY;
		this.lastName = StringUtils.EMPTY;
		this.password = new byte[30];
		this.active = false;
		this.classification = 0;
		this.managerId = UUID.fromString("00000000-0000-0000-0000-000000000000");
	}
			
	public EmployeeEntity(int employeeId, String firstName, String lastName, byte[] password, boolean active, int classification, UUID managerId) {
		this.id = new UUID(0, 0);
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
		this.classification = classification;
		this.managerId = managerId;
	}
			
	public EmployeeEntity(final Employee apiEmployee) {
		this.id = new UUID(0, 0);
		this.employeeId = apiEmployee.getEmployeeId();
		this.firstName = apiEmployee.getFirstName();
		this.lastName = apiEmployee.getLastName();
		this.password = apiEmployee.getPassword();
		this.active = apiEmployee.isActive();
		this.classification = apiEmployee.getClassification();
		this.managerId = apiEmployee.getManagerId();
	}
}