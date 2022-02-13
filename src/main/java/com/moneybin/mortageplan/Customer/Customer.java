package com.moneybin.mortageplan.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
        name = "customer_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_sequence"
    )
    private Long id;
    private String name;
    private Double totalLoan;        
    private Double interest;
    private int years;
    private Double monthlyPayment;     

    //constructors
    public Customer(){
    }

    public Customer(String name, Double totalLoan, Double interest, int years){
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    //calculate monthly payment and set the monthlyPayment variable
    /** 
     * E = U[b(1 + b)^p]/[(1 + b)^p - 1]
     * 
     * E = Fixed monthly payment
     * b = Interest on a monthly basis
     * U = Total loan
     * p = Number of payments
    */
    public void calculateMonthly(){
        int totalLoanC = (int)(this.totalLoan *100); //calculate in cents
        int p = 12*this.years;                  //number of payments p = 12 * number of years
        Double prcIntr = this.interest/100/12; //interest to percentage and per month
        int monthlyC = (int)(totalLoanC * (prcIntr * power(1+prcIntr, p))/ (power(1+prcIntr, p) - 1)); //calculation
        this.monthlyPayment = ((double)monthlyC) /100;  //convert back to euros
    }
    //helper method for calculating monthly payment
    public static Double power(Double base, int exponent){
        if(exponent == 0){
            return 1.0;
        } else{
            return (base * power(base, exponent-1));
        }
    }

    //Getters and setters
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Double return the totalLoan
     */
    public Double getTotalLoan() {
        return totalLoan;
    }

    /**
     * @param totalLoan the totalLoan to set
     */
    public void setTotalLoan(Double totalLoan) {
        this.totalLoan = totalLoan;
    }

    /**
     * @return Double return the interest
     */
    public Double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(Double interest) {
        this.interest = interest;
    }

    /**
     * @return int return the years
     */
    public int getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * @return Double return the monthlyPayment
     */
    public Double getMonthlyPayment() {
        return monthlyPayment;
    }
}
