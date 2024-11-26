package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    Optional<Expense> findById(Long id);

    List<Expense> findAll();

    Integer save(Expense expense);

    Integer update(Expense expense, Long id);

    Integer delete(Long id);

}
