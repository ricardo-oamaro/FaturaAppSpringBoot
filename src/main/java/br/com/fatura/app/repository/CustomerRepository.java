package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Customer;
import br.com.fatura.app.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    Integer save(Customer customer);

    Integer update(Customer customer, Long id);

    Integer delete(Long id);
}
