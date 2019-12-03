package com.bestarch.cart.model;

public class Discount {

	private double amount;

	private String type;

	public Discount(double amount, String type) {
		this.amount = amount;
		this.type = type;
	}
	
	public Discount() {	}
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
