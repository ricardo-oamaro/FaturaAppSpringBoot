package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl {

    @Autowired
    private JdbcClient jdbcClient;

    public List<Customer> findAll() {
        return jdbcClient
                .sql("SELECT * FROM customer")
                .query(Customer.class)
                .list();
    }

    public Optional<Customer> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM customer WHERE id = ?")
                .param("id", id)
                .query(Customer.class)
                .optional();
    }

    public Integer save(Customer customer) {
        return jdbcClient
                .sql("INSERT INTO customer (name) VALUES (?)")
                .param("name", customer.getName())
                .update();
    }

    public Integer update(Customer customer, Long id) {
        return jdbcClient
                .sql("UPDATE customer SET name = ? WHERE id = ?")
                .param("name", customer.getName())
                .param("id", id)
                .update();
    }

    public Integer deleteById(Long id) {
        return jdbcClient
                .sql("DELETE FROM customer WHERE id = ?")
                .param("id", id)
                .update();
    }
}
