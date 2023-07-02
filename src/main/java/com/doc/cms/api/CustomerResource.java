package com.doc.cms.api;

import com.doc.cms.model.Customer;
import com.doc.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return service.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return service.updateCustomer(customerId, customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        service.deleteCustomer(customerId);
    }
}
