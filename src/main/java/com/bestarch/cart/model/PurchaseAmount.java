package com.bestarch.cart.model;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAmount {
	
	private double baseAmount;
	
	private List<Discount> applicableDiscounts = new ArrayList<>();

	public double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	public List<Discount> getApplicableDiscounts() {
		return applicableDiscounts;
	}

	public double getBillAmount() {
		applicableDiscounts.stream().forEach(discount -> {
			baseAmount -= discount.getAmount();
		});
		return baseAmount;
	}

}
