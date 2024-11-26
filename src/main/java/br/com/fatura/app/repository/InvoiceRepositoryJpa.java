package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepositoryJpa extends JpaRepository<Invoice, Long> {

}
