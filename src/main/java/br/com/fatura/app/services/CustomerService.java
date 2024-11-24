package br.com.fatura.app.services;


import br.com.fatura.app.entities.Customer;
import br.com.fatura.app.entities.Invoice;
import br.com.fatura.app.repository.CustomerRepository;
import br.com.fatura.app.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void save(Customer customer) {
        var save = customerRepository.save(customer);
        Assert.state(save == 1, "Error saving customer");
    }

    public void update(Customer customer, Long id) {
        var update = customerRepository.update(customer, id);
        if (update == 0) {
            throw new RuntimeException("Error updating customer");
        }
    }

    public void delete(Long id){
        var delete = customerRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Error deleting customer");
        }
    }
}
