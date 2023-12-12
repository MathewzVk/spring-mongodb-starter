package com.mathewzvk.mongodbstarter.controller;

import com.mathewzvk.mongodbstarter.model.Expense;
import com.mathewzvk.mongodbstarter.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    final ExpenseService service;


    public ExpenseController(ExpenseService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense theExpense){
        this.service.addExpense(theExpense);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(this.service.getAllExpenses());
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense theExpense){
        this.service.updateExpense(theExpense);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(this.service.findByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable String id){
        this.service.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
