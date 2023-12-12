package com.mathewzvk.mongodbstarter.service;

import com.mathewzvk.mongodbstarter.model.Expense;
import com.mathewzvk.mongodbstarter.repo.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addExpense(Expense expense) {
        repository.insert(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public void updateExpense(Expense expense) {
        Expense savedExpense = repository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Expense by ID %s", expense.getId())
                ));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        repository.save(expense);

    }

    @Override
    public Expense findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Expense with name %s", name)));
    }

    @Override
    public void deleteExpense(String id) {
        repository.deleteById(id);
    }
}
