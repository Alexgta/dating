package com.job4j.dating.controller;

import com.job4j.dating.entity.Customer;
import com.job4j.dating.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService theCustomerService;

	public CustomerController(CustomerService pCustomerService) {
		theCustomerService = pCustomerService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from db
		List<Customer> theCustomers = theCustomerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customers/customers-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from the service
		Customer theCustomer = theCustomerService.findById(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customers/customers-form";
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer
		theCustomerService.save(theCustomer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the customer
		theCustomerService.deleteById(theId);
		
		// redirect to /carsjpa/list
		return "redirect:/customer/list";
		
	}
}


