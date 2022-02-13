package com.moneybin.mortageplan;


import static org.junit.jupiter.api.Assertions.assertTrue;
import com.moneybin.mortageplan.Customer.Customer;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    
    @Test
    public void testPower(){
        assertTrue(Customer.power(1.0,0) == 1);
        assertTrue(Customer.power(0.0,2) == 0);
        assertTrue(Customer.power(-2.0,3) == (-8));
        assertTrue(Customer.power(5.0,2) == (25));
    }

    @Test
    public void testCalculateMonthly(){
        Customer customer = new Customer();
        customer.setYears(3);
        customer.setTotalLoan(1234.56);
        customer.setInterest(4.0);
        customer.calculateMonthly();
        assertTrue(customer.getMonthlyPayment() == 36.44);

        customer.setYears(1);
        customer.setTotalLoan(6543.21);
        customer.setInterest(10.0);
        customer.calculateMonthly();
        assertTrue(customer.getMonthlyPayment() == 575.25);
    }    
}
