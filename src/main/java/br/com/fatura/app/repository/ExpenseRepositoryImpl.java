package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<Expense> findAll() {
        return jdbcClient
                .sql("SELECT * FROM expenses")
                .query(Expense.class)
                .list();
    }

    @Override
    public Optional<Expense> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM expenses WHERE id = :id")
                .param("id", id)
                .query(Expense.class)
                .optional();
    }

    @Override
    public Integer save(Expense expense) {
        return jdbcClient
                .sql("INSERT INTO expenses (expense_date, expense_description, amount, category) VALUES (?, ?, ?, ?)")
                .params(expense.getExpenseDate(),
                        expense.getExpenseDescription(),
                        expense.getAmount(),
                        expense.getCategory().name()
                )
                .update();
    }

    @Override
    public Integer update(Expense expense, Long id) {
        return jdbcClient
                .sql("UPDATE expenses SET expense_date = ?, expense_description = ?, amount = ?, category = ? WHERE id = ?")
                .params(expense.getExpenseDate(),
                        expense.getExpenseDescription(),
                        expense.getAmount(),
                        expense.getCategory().name(),
                        id
                )
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("DELETE FROM expenses WHERE id = :id")
                .param("id", id)
                .update();
    }
}
