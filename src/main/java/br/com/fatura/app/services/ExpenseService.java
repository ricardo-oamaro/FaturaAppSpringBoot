package br.com.fatura.app.services;

import br.com.fatura.app.entities.Expense;
import br.com.fatura.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

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

    public void save(Expense expense) {
        var save = expenseRepository.save(expense);
        Assert.state(save == 1, "Error saving expense");
    }

    public void update(Expense expense, Long id) {
        var update = expenseRepository.update(expense, id);
        if (update == 0) {
            throw new RuntimeException("Error updating expense");
        }
    }

    public void delete(Long id){
        var delete = expenseRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Error deleting expense");
        }
    }

}
