package com.pfonseca.erp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Sale extends DefaultEntity {

	@Id
	@SequenceGenerator(name = "SEQ_SALE", sequenceName = "SEQ_SALE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SALE")
	private Long id;
	
	@Valid
	@NotNull
	@ManyToOne
	private Contact client;
	
	@Valid
	@NotEmpty
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sale")
	private List<SaleItem> items;
	
	@Valid
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private Payment payment;
	
	
	public Contact getClient() {
		return client;
	}
	public void setClient(Contact client) {
		this.client = client;
	}
	public List<SaleItem> getItems() {
		return items;
	}
	public void setItems(List<SaleItem> items) {
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
