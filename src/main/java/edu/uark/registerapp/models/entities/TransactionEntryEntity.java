package edu.uark.registerapp.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import edu.uark.registerapp.models.api.TransactionEntry;

@Entity
@Table(name="transactionentry")
public class TransactionEntryEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}

    @Column(name="transactionid")
    private UUID transactionId;

	public UUID getTransactionId() {
		return this.transactionId;
	}

	public TransactionEntryEntity setTransactionId(final UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}

    @Column(name="productid")
    private UUID productId;

	public UUID getProductId() {
		return this.productId;
	}

	public TransactionEntryEntity setProductId(final UUID productId) {
		this.productId = productId;
		return this;
	}

	@Column(name = "lookupcode")
	private String lookupCode;

	public String getLookupCode() {
		return this.lookupCode;
	}

    @Column(name="quantity")
    private int quantity;

	public int getQuantity() {
		return this.quantity;
	}

	public TransactionEntryEntity setQuantity(final int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Column(name="stock")
    private int stock;

	public int getStock() {
		return this.stock;
	}

	public TransactionEntryEntity setStock(final int stock) {
		this.stock = stock;
		return this;
	}

    @Column(name="price")
    private double price;

	public double getPrice() {
		return this.price;
	}

	public TransactionEntryEntity setPrice(final double price) {
		this.price = price;
		return this;
	}

	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public TransactionEntryEntity() {
		this.lookupCode = "";
		this.price = 0.00;
		this.quantity = 0;
		this.id = new UUID(0, 0);
		this.productId = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
	}

	public TransactionEntryEntity(
		final String lookupCode,
		final UUID transactionId,
		final UUID productId,
		final int quantity,
		final int stock,
		final double price
	) {
		this.lookupCode = lookupCode;
		this.price = price;
		this.id = new UUID(0, 0);
		this.quantity = quantity;
		this.stock = stock;
		this.productId = productId;
		this.transactionId = transactionId;
	}

	public TransactionEntryEntity(TransactionEntry transactionEntry) {
		this.lookupCode = transactionEntry.getLookupCode();
		this.price = transactionEntry.getPrice();
		this.id = new UUID(0, 0);
		this.quantity = transactionEntry.getQuantity();
		this.stock = transactionEntry.getStock();
		this.productId = transactionEntry.getProductId();
		this.transactionId = transactionEntry.getTransactionId();
	}
}
