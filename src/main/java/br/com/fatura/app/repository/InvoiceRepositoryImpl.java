package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepositoryImpl {

    @Autowired
    private JdbcClient jdbcClient;

    public List<Invoice> findAll() {
        return jdbcClient
                .sql("SELECT * FROM invoice")
                .query(Invoice.class)
                .list();
    }

    public Optional<Invoice> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM invoice WHERE id = ?")
                .param("id", id)
                .query(Invoice.class)
                .optional();
    }

    public Integer save(Invoice invoice) {
        return jdbcClient
                .sql("INSERT INTO invoice (date, description, value, insert_date) VALUES (?, ?, ?, ?)")
                .param("date", invoice.getDate())
                .param("description", invoice.getDescription())
                .param("value", invoice.getAmount())
                .param("insert_date", invoice.getInsertDate())
                .update();
    }

    public Integer update(Invoice invoice, Long id) {
        return jdbcClient
                .sql("UPDATE invoice SET date = ?, description = ?, value = ?, insert_date = ? WHERE id = ?")
                .param("date", invoice.getDate())
                .param("description", invoice.getDescription())
                .param("value", invoice.getAmount())
                .param("insert_date", invoice.getInsertDate())
                .param("id", id)
                .update();
    }

    public Integer deleteById(Long id) {
        return jdbcClient
                .sql("DELETE FROM invoice WHERE id = ?")
                .param("id", id)
                .update();
    }


}
