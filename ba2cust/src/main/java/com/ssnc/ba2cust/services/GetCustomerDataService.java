package com.ssnc.ba2cust.services;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.ssnc.ba2cust.servicesimpl.GetCustomerImpl;

public class GetCustomerDataService {
	 
	GetCustomerImpl getCustomerImpl  = new GetCustomerImpl(); 
	  public String getData() throws ClassNotFoundException, SQLException, NamingException{
		  String rs = getCustomerImpl.getData();
		return rs;
	  }
	  public String getSpartnData() throws ClassNotFoundException, SQLException, NamingException{
		  String rs = getCustomerImpl.getSpartn();
		return rs;
	  }
	  public String getSourceTypesData() throws ClassNotFoundException, SQLException, NamingException{
		  String rs = getCustomerImpl.getSourceTypes();
		return rs;
	  }
	  public String getAwdBatchData() throws ClassNotFoundException, SQLException, NamingException{
		  String rs = getCustomerImpl.getAwdBatchTypes();
		return rs;
	  }
}
