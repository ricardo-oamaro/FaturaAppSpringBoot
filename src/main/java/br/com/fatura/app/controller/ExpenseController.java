package br.com.fatura.app.controller;

import br.com.fatura.app.entities.Expense;
import br.com.fatura.app.services.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> findAllExpenses() {
        logger.info("Listing all expenses");
        return ResponseEntity.ok(expenseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> findExpenseById(
            @PathVariable("id") Long id
    ) {
        logger.info("Finding expense by id: {}", id);
        return ResponseEntity.ok(expenseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveExpense(
            @RequestBody Expense expense
    ) {
        logger.info("Saving expense: {}", expense);
        expenseService.save(expense);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense
    ) {
        logger.info("Updating expense: {}", expense);
        expenseService.update(id, expense);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long id
    ) {
        logger.info("Deleting expense by id: {}", id);
        expenseService.delete(id);
        return ResponseEntity.status(204).build();
    }


}
