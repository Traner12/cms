package com.doc.cms.service;


import com.doc.cms.dao.CustomerDAO;
import com.doc.cms.exception.CustomerNotFoundexception;
import com.doc.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO dao;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer){
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/

        return dao.save(customer);
    }

    public List<Customer> getCustomers(){
        return dao.findAll();
    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer = dao.findById(customerId);

        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundexception("Customer record is not available");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){

        /*customerList
                .stream()
                .forEach(c ->{
                    if(c.getCustomerId() == customerId){
                        c.setCustomerName(customer.getCustomerName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setPhone(customer.getPhone());
                    }
                });

        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();*/

        customer.setCustomerId(customerId);
        return dao.save(customer);
    }

    public void deleteCustomer(int customerId){
        /*customerList
                .stream()
                .forEach(c ->{
                    if (c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });*/
        dao.deleteById(customerId);
    }

}
