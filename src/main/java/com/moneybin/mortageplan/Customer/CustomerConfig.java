package com.moneybin.mortageplan.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return (args) -> {
			customerRepository.saveAll(CustomerReader.readCustomers());
		};
    }
    
}
