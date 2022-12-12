package com.antoine.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.antoine.savetravels.models.Expense;
import com.antoine.savetravels.services.ExpenseService;



@Controller
public class ExpenseController {
	
	// IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	ExpenseService expenseServ;
	
	// ------------------ DATA BINDING(CREATE) ------------------------ //
	// READ ALL
	@GetMapping("/")
	public String index(
		Model model, @ModelAttribute("expenseObj") Expense emptyExpenseObj
	) {

		List<Expense> allExpensesFromDB = expenseServ.getAllExpenses();
		

		model.addAttribute("allExpenses", allExpensesFromDB);
		
		// RENDER THE JSP
		return "index.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String processExpense(
		Model model,
		@Valid @ModelAttribute("expenseObj") Expense filledExpenseObj,
		BindingResult results
	) {
		if(results.hasErrors()) {
			model.addAttribute("allExpenses", expenseServ.getAllExpenses());
			return "index.jsp";
		}
		expenseServ.create(filledExpenseObj);
		return "redirect:/";
	}
	// ------------------ DATA BINDING(CREATE) ------------------------ //
	
	
	

	@GetMapping("/expenses/{id}")
	public String showOne(
		@PathVariable("id") Long expenseId,
		Model model
	) {

		Expense oneExpense = expenseServ.findExpense(expenseId);
		
		// PASS THE INFORMATION TO THE JSP
		model.addAttribute("expense", oneExpense);
	
		return "one.jsp";
	}
	
	
	// ------------------ DATA BINDING(CREATE) ------------------------ //
//	@GetMapping("/users/new")
//	public String newUser(
//		@ModelAttribute("userObj") User emptyUserObj
//	) {
////		model.addAttribute("userObj", new User());
//		return "create.jsp";
//	}
	
	// ------------------ DATA BINDING(CREATE) ------------------------ //
	
	// ------------------ DATA BINDING(UPDATE) ------------------------ //
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(
		@PathVariable("id") Long expenseId, Model model
	) {

		Expense oneExpense = expenseServ.findExpense(expenseId);

		model.addAttribute("expenseObj", oneExpense);
		return "edit.jsp";
	}
	@PutMapping("/expenses/{id}/edit")
	public String updateExpense(
		@Valid @ModelAttribute("expenseObj") Expense filledExpenseObj,
		BindingResult results
	) {
		if(results.hasErrors()) {
			return "edit.jsp";
		}
		expenseServ.create(filledExpenseObj);
		return "redirect:/";
	}
	// ------------------ DATA BINDING(UPDATE) ------------------------ //
	
	@DeleteMapping("/expenses/{id}/delete")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/";
	}
}