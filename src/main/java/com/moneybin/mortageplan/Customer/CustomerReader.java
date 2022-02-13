package com.moneybin.mortageplan.Customer;

import java.io.InputStream;
import java.util.Scanner;                
import java.util.ArrayList;                
import java.util.StringTokenizer;          

public class CustomerReader {
    
    public static ArrayList<Customer> readCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>(); // Create an ArrayList object
        InputStream inputStream = CustomerReader.class.getResourceAsStream("/prospects.txt");
        Scanner fileReader = new Scanner(inputStream, "UTF-8");

        fileReader.nextLine();   //Skip first line of file
        while (fileReader.hasNextLine()) {
            StringTokenizer tkn = new StringTokenizer(fileReader.nextLine(), "\", ");   //tokenize line
            if(tkn.countTokens() >= 4){               //if valid line, insert into customer object
                Customer customer = new Customer();   //create new customer
                customer.setName(tkn.nextToken());    //Set first name
                String tmp = tkn.nextToken();
                if(!isNumeric(tmp)){                  //check for second name
                    customer.setName(customer.getName() + " " + tmp );  //add second name if available
                    customer.setTotalLoan(Double.parseDouble(tkn.nextToken()));    //next token = total loan, convert to cents
                } else{
                    customer.setTotalLoan(Double.parseDouble(tmp));     //no second name => tmp = totalLoan, convert to cents
                }
                customer.setInterest(Double.parseDouble(tkn.nextToken()));  //set interest
                customer.setYears(Integer.parseInt(tkn.nextToken()));       //set number of years
                customer.calculateMonthly();    //calculate monthly payment for customer
                customers.add(customer);        //add customer to list
            }
        }
        fileReader.close();
        return customers;
    }
    //Helper method for readCustomers. Checks if a string is numeric.
    public static boolean isNumeric(String string){
        return string.chars().allMatch( ch -> (Character.isDigit(ch) || ch == '.' ) );
    }
}
