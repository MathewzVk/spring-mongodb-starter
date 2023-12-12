package com.mathewzvk.mongodbstarter.service;

import com.mathewzvk.mongodbstarter.model.Expense;

import java.util.List;

public interface ExpenseService {

    public void addExpense(Expense expense);

    public List<Expense> getAllExpenses();

    public void updateExpense(Expense expense);

    public Expense findByName(String name);

    public void deleteExpense(String id);

}
