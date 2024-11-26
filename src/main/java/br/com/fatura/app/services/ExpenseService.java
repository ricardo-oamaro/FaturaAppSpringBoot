package br.com.fatura.app.services;

import br.com.fatura.app.entities.Expense;
import br.com.fatura.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense update(Long id, Expense expense) {
        Optional<Expense> currentExpense = expenseRepository.findById(id);

        if(currentExpense.isPresent()){
            Expense expenseToUpdate = currentExpense.get();
            expenseToUpdate.setExpenseDate(expense.getExpenseDate());
            expenseToUpdate.setExpenseDescription(expense.getExpenseDescription());
            expenseToUpdate.setAmount(expense.getAmount());
            expenseToUpdate.setCategory(expense.getCategory());
            return expenseRepository.save(expenseToUpdate);
        } else {
            throw new IllegalArgumentException("Expense not found");
        }
    }

    public void delete(Long id){
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Expense not found");
        }

    }


}
