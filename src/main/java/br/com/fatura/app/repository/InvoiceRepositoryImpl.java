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
                .sql("SELECT * FROM invoices")
                .query(Invoice.class)
                .list();
    }

    public Optional<Invoice> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM invoices WHERE id = :id")
                .param("id", id)
                .query(Invoice.class)
                .optional();
    }

    public Integer save(Invoice invoice) {
        return jdbcClient
                .sql("INSERT INTO invoices (invoice_date, invoice_description, amount) VALUES (?, ?, ?)")
                .param(invoice.getInvoiceDate())
                .param(invoice.getInvoiceDescription())
                .param(invoice.getAmount())
                .update();
    }

    public Integer update(Invoice invoice, Long id) {
        return jdbcClient
                .sql("UPDATE invoices SET invoice_date = ?, invoice_description = ?, amount = ?, insert_date = ? WHERE id = ?")
                .param(invoice.getInvoiceDate())
                .param(invoice.getInvoiceDescription())
                .param(invoice.getAmount())
                .param(invoice.getInsertDate())
                .param(id)
                .update();
    }

    public Integer deleteById(Long id) {
        return jdbcClient
                .sql("DELETE FROM invoices WHERE id = ?")
                .param("id", id)
                .update();
    }


}
