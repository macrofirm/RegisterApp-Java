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

@Entity
@Table(name="transaction")
public class TransactionEntity {
    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

	public UUID getId() {
		return this.id;
	}

    @Column(name="cashierid")
    private UUID cashierId;

	public UUID getCashierId() {
		return this.cashierId;
	}

	public TransactionEntity setCashierId(final UUID cashierId) {
		this.cashierId = cashierId;
		return this;
	}

    @Column(name="total")
    private double total;

	public double getTotal() {
		return this.total;
	}

	public TransactionEntity setTotal(final double total) {
		this.total = total;
		return this;
	}

	@Column(name = "createdon", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
	private LocalDateTime createdOn;

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public TransactionEntity() {
		this.total = 0L;
		this.id = new UUID(0, 0);
		this.cashierId = new UUID(0, 0);
	}

	public TransactionEntity(
		final UUID cashierId,
		final long total
	) {

		this.total = total;
		this.id = new UUID(0, 0);
		this.cashierId = cashierId;
	}
}
