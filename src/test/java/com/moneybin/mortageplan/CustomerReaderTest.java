package com.moneybin.mortageplan;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.moneybin.mortageplan.Customer.CustomerReader;

public class CustomerReaderTest {
    
    @Test
    public void testIsNumeric(){
        assertTrue(CustomerReader.isNumeric("24162"));
        assertTrue(CustomerReader.isNumeric("23.456"));
        assertTrue(!CustomerReader.isNumeric("test"));
    }
}
