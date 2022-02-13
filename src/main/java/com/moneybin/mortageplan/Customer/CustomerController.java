package com.moneybin.mortageplan.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    
    private  final  CustomerService customerService;

    //constructor
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
	public String getCustomers(Model model){
        return customerService.getCustomers(model);
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveCustomer(Model model, @ModelAttribute Customer customer){
        customer.calculateMonthly();
        customerService.addNewCustomer(customer);
        return "redirect:/";        
    }
}
