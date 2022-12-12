package com.antoine.savetravels.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antoine.savetravels.models.Expense;
import com.antoine.savetravels.services.ExpenseService;



@RestController
public class ApiController {
	
	// IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	ExpenseService expenseServ;
	
	
	// CREATE USER
	@PostMapping("/api/expenses/new")
	public String create(
	    @RequestParam("name") String name,
		@RequestParam("vendor") String vendor,
		@RequestParam("amount") double amount,
		@RequestParam("description") String description
	) {
		Expense newExpense = new Expense(name, vendor, amount, description);
		return expenseServ.create(newExpense).toString();
	}
	
	// READ ALL USER
	
	// READ ONE USER
	
	
	// UPDATE USER
	
	
	// DELETE USER
	
}