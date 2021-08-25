package com.ssnc.ba2cust.junits;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Test;

import com.ssnc.ba2cust.resources.GetSpartnData;
import com.ssnc.ba2cust.services.GetCustomerDataService;

public class ARTNTest {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() throws ClassNotFoundException, SQLException, NamingException {
    	GetCustomerDataService tester = new GetCustomerDataService(); // MyClass is tested

        // assert statements
        assertEquals( 663 , tester.getSpartnData( ) );
        
    }
}