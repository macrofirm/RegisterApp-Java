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

import edu.uark.registerapp.models.api.ActiveUser;

@Entity
@Table(name="activeuser")
public class ActiveUserEntity {
	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
		private final UUID id;
	
			public UUID getId() {
				return this.id;
			}

	@Column(name = "employeeid")
		private UUID employeeId;
		
			public UUID getEmployeeId() {
				return this.employeeId;
			}
		
			public ActiveUserEntity setEmployeeId(final UUID employeeId) {
				this.employeeId = employeeId;
				return this;
			}
	
	@Column(name = "name")
		private String name;
		
			public String getName() {
				return this.name;
			}
		
			public ActiveUserEntity setName(final String name) {
				this.name = name;
				return this;
			}
	
	@Column(name = "classification")
		private int classification;
		
			public int getClassification() {
				return this.classification;
			}
		
			public ActiveUserEntity setClassification(final int classification) {
				this.classification = classification;
				return this;
			}
		
	@Column(name = "sessionkey")
		private String sessionKey;
		
			public String getSessionKey() {
				return this.sessionKey;
			}
		
			public ActiveUserEntity setSessionKey(final String sessionKey) {
				this.sessionKey = sessionKey;
				return this;
			}
		
	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	
		private LocalDateTime createdOn;

			public LocalDateTime getCreatedOn() {
				return this.createdOn;
			}
			
	public ActiveUser synchronize(final ActiveUser apiActiveUser) {
		this.setEmployeeId(apiActiveUser.getEmployeeId());
		this.setName(apiActiveUser.getName());
		this.setClassification(apiActiveUser.getClassification());
		this.setSessionKey(apiActiveUser.getSessionKey());
		
		apiActiveUser.setId(this.getId());
		apiActiveUser.setCreatedOn(this.getCreatedOn());
		
		return apiActiveUser;
	}	
			
	public ActiveUserEntity() {
		this.id = new UUID(0, 0);
		this.employeeId = new UUID(0, 0);
		this.name = StringUtils.EMPTY;
		this.classification = -1;
		this.sessionKey = StringUtils.EMPTY;
	}
		
	public ActiveUserEntity(UUID employeeId, String name, int classification, String sessionKey) {
		this.id = new UUID(0, 0);
		this.employeeId = employeeId;
		this.name = name;
		this.classification = classification;
		this.sessionKey = sessionKey;
	}

	public ActiveUserEntity(ActiveUser apiActiveUser) {
		this.id = new UUID(0, 0);
		this.employeeId = apiActiveUser.getEmployeeId();
		this.name = apiActiveUser.getName();
		this.classification = apiActiveUser.getClassification();
		this.sessionKey = apiActiveUser.getSessionKey();
	}
			
			
			
			
			
			
			
			
			
			
			
}
