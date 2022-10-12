package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	
	@Autowired
	private CustomerService customerService;	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create new model to bind from data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
	 
		
		return "customer-form";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theID, Model theModel) {
 		 
		//get the customer from the our service
		Customer theCustomer = customerService.getCustomer(theID);
		//set customer as a model attribute to pro-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// redirect to form
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer")Customer theCustomer) {
		
		// save the customer
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showListForDelete")
	public String showListForDelete(@RequestParam("customerId") int theID, Model theModel) {
 		 
		//get the customer from the our service
		//set customer as a model attribute to pro-populate the form
 		customerService.deleteCustomer(theID);

		// redirect to form
		return "redirect:/customer/list";
	}
	
}
