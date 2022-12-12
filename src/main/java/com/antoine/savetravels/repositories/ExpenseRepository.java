package com.antoine.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.antoine.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// GET ALL METHOD
	List<Expense> findAll();
	
	// CUSTOM QUERIES
	List<Expense> findByVendor(String search);
}