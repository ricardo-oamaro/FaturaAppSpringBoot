package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public Optional<Invoice> findById(Long id) {
        return jdbcClient
                .sql("SELECT i.id, i.card_id, i.customer_id, i.invoice_date, i.invoice_description, i.amount, i.category, i.insert_date, " +
                        "c.customer_name, " +
                        "cr.card_name " +
                        "FROM invoices i " +
                        "INNER JOIN customers c ON i.customer_id = c.id " +
                        "INNER JOIN cards cr ON i.card_id = cr.id " +
                        "WHERE i.id = :id")
                .param("id", id)
                .query(Invoice.class)
                .optional();
    }

    @Override
    public List<Invoice> findAll() {
        return jdbcClient
                .sql("SELECT i.id, i.card_id, i.customer_id, i.invoice_date, i.invoice_description, i.amount, i.category, i.insert_date, " +
                        "c.customer_name, " +
                        "cr.card_name " +
                        "FROM invoices i " +
                        "INNER JOIN customers c ON i.customer_id = c.id " +
                        "INNER JOIN cards cr ON i.card_id = cr.id ")
                .query(Invoice.class)
                .list();
    }

    @Override
    public Integer save(Invoice invoice) {
        return jdbcClient
                .sql("INSERT INTO invoices(invoice_date, invoice_description, amount, category, customer_id, card_id) VALUES (?, ?, ?, ?, ?, ?)")
                .params(invoice.getInvoiceDate(),
                        invoice.getInvoiceDescription(),
                        invoice.getAmount(),
                        invoice.getCategory().name(),
                        invoice.getCustomerId(),  //TODO: anterar os repositories de customer e cards para JPA
                        invoice.getCardId()
                )
                .update();
    }

    @Override
    public Integer update(Invoice invoice, Long id) {
        return jdbcClient
                .sql("UPDATE invoices SET invoice_date = ?, invoice_description = ?, amount = ? WHERE id = ?")
                .params(invoice.getInvoiceDate(),
                        invoice.getInvoiceDescription(),
                        invoice.getAmount(),
                        id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return jdbcClient
                .sql("DELETE FROM invoices WHERE id = :id")
                .param("id", id)
                .update();
    }

}
