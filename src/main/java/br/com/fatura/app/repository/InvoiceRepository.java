package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository{

    Optional<Invoice> findById(Long id);

    List<Invoice> findAll();

    Integer save(Invoice invoice);

    Integer update(Invoice invoice, Long id);

    Integer delete(Long id);

}
