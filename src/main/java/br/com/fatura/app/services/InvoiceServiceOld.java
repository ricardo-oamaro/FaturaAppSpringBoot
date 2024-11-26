package br.com.fatura.app.services;

import br.com.fatura.app.dto.InvoiceRequestDto;
import br.com.fatura.app.entities.Invoice;
import br.com.fatura.app.repository.InvoiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class InvoiceServiceOld {

    @Autowired
    private InvoiceRepositoryImpl invoiceRepository;


    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public void save(InvoiceRequestDto invoice) {
        var invoiceEntity = convertData(invoice);
        var save = invoiceRepository.save(invoiceEntity);
        Assert.state(save == 1, "Error saving invoice");
    }

    public void update(Invoice invoice, Long id) {
        var update = invoiceRepository.update(invoice, id);
        if (update == 0) {
            throw new RuntimeException("Error updating invoice");
        }
    }

    public void delete(Long id) {
        var delete = invoiceRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Error deleting invoice");
        }
    }

    public Invoice convertData(InvoiceRequestDto invoiceRequestDto) {
        return new Invoice(invoiceRequestDto);
    }

}
