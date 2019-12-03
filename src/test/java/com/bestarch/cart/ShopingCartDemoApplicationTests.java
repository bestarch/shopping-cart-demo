package com.bestarch.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestarch.cart.model.PurchaseAmount;
import com.bestarch.cart.service.ShopingCartService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ShopingCartDemoApplication.class })
public class ShopingCartDemoApplicationTests {

	@Autowired
	private ShopingCartService shopingCartService;
	
	@Test
	public void testDiscountWhenPurchaseAmount_15000() throws Exception {
		PurchaseAmount purchaseAmount = new PurchaseAmount();
		purchaseAmount.setBaseAmount(15000);
		shopingCartService.processDiscounts(purchaseAmount);
		assertEquals(13500.0, purchaseAmount.getBillAmount(), 0.0);
	}
	
	@Test
	public void testDiscountWhenPurchaseAmount_10000() throws Exception {
		PurchaseAmount purchaseAmount = new PurchaseAmount();
		purchaseAmount.setBaseAmount(10000);
		shopingCartService.processDiscounts(purchaseAmount);
		assertEquals(9500.0, purchaseAmount.getBillAmount(), 0.0);
	}
	
	@Test
	public void testDiscountWhenPurchaseAmount_5000() throws Exception {
		PurchaseAmount purchaseAmount = new PurchaseAmount();
		purchaseAmount.setBaseAmount(5000);
		shopingCartService.processDiscounts(purchaseAmount);
		assertEquals(5000, purchaseAmount.getBillAmount(), 0.0);
	}

}
