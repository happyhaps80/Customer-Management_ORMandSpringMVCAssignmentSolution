package com.crm.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.crm.model.Customer;
import com.crm.service.CustomerService;

@Component
public class PopulateData implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	CustomerService customerService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		customerService.save(new Customer("Harshit", "Choudhary", "Harshit@greatlearning.in"));
		customerService.save(new Customer("Ankit", "Garg", "Ankit@greatlearning.in"));
		customerService.save(new Customer("Monica", "Sharma", "Monica@greatlearning.in"));
		customerService.save(new Customer("Bhavya", "Shetty", "Bhavya@greatlearning.in"));
	}

}