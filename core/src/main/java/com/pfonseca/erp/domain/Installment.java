package com.pfonseca.erp.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Installment extends DefaultEntity {

	@Id
	@SequenceGenerator(name = "SEQ_INSTALLMENT", sequenceName = "SEQ_INSTALLMENT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSTALLMENT")
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@NotNull
	private ZonedDateTime dueDate;
	
	@NotNull
	private Boolean paid = false;
	
	@NotNull
	@Column(name="INSTALLMENT_VALUE")
	private BigDecimal value;
	
	@ManyToOne(optional=false)
	private Payment payment;

	public ZonedDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(ZonedDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	} 
	
	
}
