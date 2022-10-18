package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.model.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("Customers", theCustomers);
		return "list-customers";
	}

	@RequestMapping("/show-add-form")
	public String showAddForm(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("Customer", theCustomer);
		return "edit-customer";
	}

	@RequestMapping("/show-update-form")
	public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("Customer", theCustomer);
		return "edit-customer";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("emailId") String emailId) {
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmailId(emailId);
		} else {
			theCustomer = new Customer();
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmailId(emailId);
		}
		customerService.save(theCustomer);
		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customers/list";
	}
}
