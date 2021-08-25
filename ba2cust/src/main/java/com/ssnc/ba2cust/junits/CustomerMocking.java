package com.ssnc.ba2cust.junits;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 



import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ssnc.ba2cust.services.GetCustomerDataService;
import com.ssnc.ba2cust.servicesimpl.GetCustomerImpl;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class CustomerMocking {
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   GetCustomerDataService customerDataService = new GetCustomerDataService();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   GetCustomerImpl calcService;

   @Test
   public void testAdd() throws ClassNotFoundException, SQLException, NamingException{
      //add the behavior of calc service to add two numbers
     // when(calcService.getSpartn());
		
      //test the add functionality
      Assert.assertEquals(calcService.getData(),"true","true");
   }
}