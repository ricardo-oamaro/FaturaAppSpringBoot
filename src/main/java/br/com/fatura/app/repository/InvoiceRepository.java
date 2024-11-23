package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository{

    Optional<Invoice> findById(Long id);

    List<Invoice> findAll(int size, int offset);

    Integer save(Invoice veiculo);

    Integer update(Invoice veiculo, Long id);

    Integer delete(Long id);

}