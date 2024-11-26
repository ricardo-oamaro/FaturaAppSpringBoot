package br.com.fatura.app.services;

import br.com.fatura.app.entities.Expense;
import br.com.fatura.app.repository.ExpenseRepository;
import br.com.fatura.app.repository.ExpenseRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseRepositoryJpa expenseRepositoryJpa;

    public List<Expense> findAll() {
        return expenseRepositoryJpa.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepositoryJpa.findById(id).orElse(null);
    }

    public Expense save(Expense expense) {
        return expenseRepositoryJpa.save(expense);
    }

    public Expense update(Long id, Expense expense) {
        Optional<Expense> currentExpense = expenseRepositoryJpa.findById(id);

        if(currentExpense.isPresent()){
            Expense expenseToUpdate = currentExpense.get();
            expenseToUpdate.setExpenseDate(expense.getExpenseDate());
            expenseToUpdate.setExpenseDescription(expense.getExpenseDescription());
            expenseToUpdate.setAmount(expense.getAmount());
            expenseToUpdate.setCategory(expense.getCategory());
            return expenseRepositoryJpa.save(expenseToUpdate);
        } else {
            throw new IllegalArgumentException("Expense not found");
        }
    }

    public void delete(Long id){
        if (expenseRepositoryJpa.existsById(id)) {
            expenseRepositoryJpa.deleteById(id);
        } else {
            throw new IllegalArgumentException("Expense not found");
        }

    }


}
