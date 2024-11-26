package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepositoryJpa extends JpaRepository<Expense, Long> {
}
