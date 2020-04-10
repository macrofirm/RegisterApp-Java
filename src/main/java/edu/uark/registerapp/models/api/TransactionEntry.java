package edu.uark.registerapp.models.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import edu.uark.registerapp.models.entities.TransactionEntryEntity;

public class TransactionEntry extends ApiResponse{
	private UUID id;
	
	public UUID getId() {
		return this.id;
	}
	
	public TransactionEntry setId(final UUID id) {
		this.id = id;
		return this;
	}
	
	private UUID transactionid;
	
	public UUID getTransactionId() {
		return this.transactionid;
	}
	
	public TransactionEntry setTransactionId(final UUID transactionid) {
		this.transactionid = transactionid;
		return this;
	}
	
	private UUID productid;
	
	public UUID getProductId() {
		return this.productid;
	}
	
	public TransactionEntry setProductId(final UUID productid) {
		this.productid = productid;
		return this;
	}
	
	private double quantity;
	
	public double getQuantity() {
		return this.quantity;
	}
	
	public TransactionEntry setQuantity(final double quantity) {
		this.quantity = quantity;
		return this;
	}
	
	private long price;
	
	public long getPrice() {
		return this.price;
	}
	
	public TransactionEntry setPrice(final long price) {
		this.price = price;
		return this;
	}
	
	private String createdOn;
	
	public String getCreatedOn() {
		return this.createdOn;
	}
	
	public TransactionEntry setCreatedOn(final String createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public TransactionEntry setCreatedOn(final LocalDateTime createdOn) {
		this.createdOn = createdOn.format(DateTimeFormatter.ofPattern("MM/dd/yyy"));
		return this;
	}
	
	public TransactionEntry() {
		super();
		
		this.id = new UUID(0, 0);
		this.transactionid = new UUID(0, 0);
		this.productid = new UUID(0, 0);
		this.quantity = 0D;
		this.price = 0L;
		this.setCreatedOn(LocalDateTime.now());
	}
	
	public TransactionEntry(final TransactionEntryEntity transactionEntryEntity) {
		super(false);
		
		this.id = transactionEntryEntity.getId();
		this.transactionid = transactionEntryEntity.getTransactionId();
		this.productid = transactionEntryEntity.getProductId();
		this.quantity = transactionEntryEntity.getQuantity();
		this.price = transactionEntryEntity.getPrice();
		this.setCreatedOn(transactionEntryEntity.getCreatedOn());
	}
}
