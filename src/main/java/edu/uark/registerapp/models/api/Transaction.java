package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import edu.uark.registerapp.models.entities.TransactionEntity;

public class Transaction extends ApiResponse{
	private UUID id;
	
	public UUID getId() {
		return this.id;
	}
	
	public Transaction setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	private UUID cashierid;
	
	public UUID getCashierId() {
		return this.cashierid;
	}
	
	public Transaction setCashierId(final UUID cashierid) {
		this.cashierid = cashierid;
		return this;
	}
	
	private double total;
	
	public double getTotal() {
		return this.total;
	}
	
	public Transaction setTotal(final double total) {
		this.total = total;
		return this;
	}
	
	private String createdOn;
	
	public String getCreatedOn() {
		return this.createdOn;
	}
	
	public Transaction setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public Transaction setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn = createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyy"));
		return this;
	}
	
	public Transaction() {
		super();
		
		this.id = new UUID(0, 0);
		this.cashierid = new UUID(0, 0);
		this.total = -1;
		this.setCreatedOn(LocalDateTime.now());
	}
	
	public Transaction(final TransactionEntity transactionEntity) {
		super(false);
		
		this.id = transactionEntity.getId();
		this.cashierid = transactionEntity.getCashierId();
		this.total = transactionEntity.getTotal();
		this.setCreatedOn(transactionEntity.getCreatedOn());
	}
	
	
	
}
