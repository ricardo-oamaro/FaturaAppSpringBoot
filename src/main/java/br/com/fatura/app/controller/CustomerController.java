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
    public ResponseEntity<Customer> findCustomerById(
            @PathVariable("id") Long id
    ) {
        logger.info("Finding invoice by id: {}", id);
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(
            @RequestBody Customer custumer
    ) {
        logger.info("Saving custumer: {}", custumer);
        customerService.save(custumer);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer
    ) {
        logger.info("Updating customer: {}", customer);
        customerService.update(customer, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable Long id
    ) {
        logger.info("Deleting invoice by id: {}", id);
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
