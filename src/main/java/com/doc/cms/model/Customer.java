package com.doc.cms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int customerId;
    @JsonProperty("name")
    private String customerName;
    @JsonProperty("lname")
    private String customerLastName;
    @JsonProperty("phone")
    private String phone;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerLastName, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
