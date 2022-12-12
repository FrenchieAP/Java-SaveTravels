package com.antoine.savetravels.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoine.savetravels.models.Expense;
import com.antoine.savetravels.repositories.ExpenseRepository;




@Service
public class ExpenseService {
	
	// IMPORT REPOSITORY
	@Autowired
	ExpenseRepository expenseRepo;

	
	// CREATE A USER
	public Expense create(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
	// GET ALL USERS
	public List<Expense> getAllExpenses(){
		return expenseRepo.findAll();
	}
	
	// GET ONE USER
    public Expense findExpense(Long id) {
    	
    	return expenseRepo.findById(id).orElse(null);
//        Optional<User> optionalUser = userRepo.findById(id);
//        if(optionalUser.isPresent()) {
//            return optionalUser.get();
//        } else {
//            return null;
//        }
    }
	// UPDATE A USER
	public Expense updateExpense(@Valid Expense updatedExpense) {
		return expenseRepo.save(updatedExpense);
	}
	
	// DELETE A USER
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}