package br.com.fatura.app.controller;

import br.com.fatura.app.entities.Customer;
import br.com.fatura.app.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        logger.info("Listing all invoices");
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(Long id) {
        logger.info("Finding invoice by id: {}", id);
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(Customer invoice) {
        logger.info("Saving invoice: {}", invoice);
        customerService.save(invoice);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(Customer invoice, Long id) {
        logger.info("Updating invoice: {}", invoice);
        customerService.update(invoice, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(Long id) {
        logger.info("Deleting invoice by id: {}", id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
