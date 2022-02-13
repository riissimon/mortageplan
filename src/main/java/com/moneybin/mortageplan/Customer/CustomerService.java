package com.moneybin.mortageplan.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public String getCustomers(Model model){
        model.addAttribute("header", "Mortgage plan");
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

    public void putCustomers(List<Customer> list){
        customerRepository.saveAll(list);
    }

}
