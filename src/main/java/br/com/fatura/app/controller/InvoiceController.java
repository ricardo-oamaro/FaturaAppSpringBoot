package br.com.fatura.app.controller;

import br.com.fatura.app.entities.Invoice;
import br.com.fatura.app.services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> findAllInvoices() {
        logger.info("Listing all invoices");
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findInvoiceById(@PathVariable("id") Long id) {
        logger.info("Finding invoice by id: {}", id);
        return ResponseEntity.ok(invoiceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        logger.info("Saving invoice: {}", invoice);
        invoiceService.save(invoice);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInvoice(
            @PathVariable("id") Long id,
            @RequestBody  Invoice invoice
    ) {
        logger.info("Updating invoice: {}", invoice);
        invoiceService.update(invoice, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(
            @PathVariable("id") Long id
    ) {
        logger.info("Deleting invoice by id: {}", id);
        invoiceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
