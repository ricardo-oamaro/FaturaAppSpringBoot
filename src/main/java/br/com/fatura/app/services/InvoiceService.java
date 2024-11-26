package br.com.fatura.app.services;

import br.com.fatura.app.dto.InvoiceRequestDto;
import br.com.fatura.app.entities.Invoice;
import br.com.fatura.app.repository.InvoiceRepositoryImpl;
import br.com.fatura.app.repository.InvoiceRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepositoryImpl invoiceRepository;

    @Autowired
    private InvoiceRepositoryJpa invoiceRepositoryJpa;

    public List<Invoice> findAll() {
        return invoiceRepositoryJpa.findAll();
    }

    public Invoice findById(Long id) {
        return invoiceRepositoryJpa.findById(id).orElse(null);
    }

    public Invoice save(InvoiceRequestDto invoice) {
        var invoiceEntity = convertData(invoice);
        return invoiceRepositoryJpa.save(invoiceEntity);
    }

    public Invoice update(Invoice invoice, Long id) {
        Optional<Invoice> currentInvoice = invoiceRepositoryJpa.findById(id);

        if(currentInvoice.isPresent()){
            Invoice invoiceToUpdate = currentInvoice.get();
            invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
            invoiceToUpdate.setInvoiceDescription(invoice.getInvoiceDescription());
            invoiceToUpdate.setAmount(invoice.getAmount());
            invoiceToUpdate.setCategory(invoice.getCategory());
            return invoiceRepositoryJpa.save(invoiceToUpdate);
        } else {
            throw new IllegalArgumentException("Invoice not found");
        }
    }

    public void delete(Long id) {
        if (invoiceRepositoryJpa.existsById(id)) {
            invoiceRepositoryJpa.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invoice not found");
        }
    }

    public Invoice convertData(InvoiceRequestDto invoiceRequestDto) {
        return new Invoice(invoiceRequestDto);
    }

}
