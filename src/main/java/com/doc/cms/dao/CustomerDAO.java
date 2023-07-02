package com.doc.cms.dao;

import com.doc.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();
}
