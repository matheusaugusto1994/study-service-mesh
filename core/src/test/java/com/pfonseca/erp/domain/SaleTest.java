package com.pfonseca.erp.domain;

import java.util.ArrayList;

public class SaleTest {

	
	public void shouldValidGetTotalWithSimpleData(){
		
		Sale sale = new Sale();
		
		sale.setPayment(new Payment());
		
		
		sale.setItems(new ArrayList<>());
		
		
	}
	
	
}
