package com.bestarch.cart.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestarch.cart.model.PurchaseAmount;

@Service
public class ShopingCartService {
	
	protected static final Logger logger = LoggerFactory.getLogger(ShopingCartService.class);
	
	@Autowired
	private KieContainer kieContainer;
	
	public void processDiscounts(PurchaseAmount purchaseAmount) throws Exception {
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(purchaseAmount); // which object to validate
		kieSession.fireAllRules(); // fire all rules defined into drool file (drl)
		kieSession.dispose();
		
	}

}
