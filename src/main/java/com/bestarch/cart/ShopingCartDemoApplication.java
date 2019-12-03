package com.bestarch.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bestarch.cart.model.PurchaseAmount;
import com.bestarch.cart.service.ShopingCartService;

@SpringBootApplication
public class ShopingCartDemoApplication implements CommandLineRunner {

	protected static final Logger logger = LoggerFactory.getLogger(ShopingCartDemoApplication.class);

	@Autowired
	private ShopingCartService shopingCartService;

	public static void main(String[] args) {
		SpringApplication.run(ShopingCartDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PurchaseAmount purchaseAmount = new PurchaseAmount();
		purchaseAmount.setBaseAmount(12000);
		logger.info("Processing discounts for purchase amount of ${}", purchaseAmount.getBaseAmount());
		shopingCartService.processDiscounts(purchaseAmount);
		logger.info("Processed bill amount is ${}", purchaseAmount.getBillAmount());
		purchaseAmount.getApplicableDiscounts().stream().forEach(discount -> logger.info("Total discount offered is ${}", discount.getAmount()));
	}

}
