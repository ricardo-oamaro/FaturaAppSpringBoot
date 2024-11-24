package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<Customer> findAll() {
        return jdbcClient
                .sql("SELECT * FROM customers")
                .query(Customer.class)
                .list();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM customers WHERE id = :id")
                .param("id", id)
                .query(Customer.class)
                .optional();
    }

    @Override
    public Integer save(Customer customer) {
        return jdbcClient
                .sql("INSERT INTO customers(customer_name) VALUES (?)")
                .param(customer.getCustomerName())
                .update();
    }

    @Override
    public Integer update(Customer customer, Long id) {
        return jdbcClient
                .sql("UPDATE customers SET customer_name = ? WHERE id = ?")
                .params(customer.getCustomerName(), id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("DELETE FROM customers WHERE id = :id")
                .param("id", id)
                .update();
    }
}
