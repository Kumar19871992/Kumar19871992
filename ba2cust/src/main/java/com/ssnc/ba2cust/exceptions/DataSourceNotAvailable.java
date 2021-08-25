package com.ssnc.ba2cust.exceptions;

public class DataSourceNotAvailable extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataSourceNotAvailable(String exceptionMsg)
	{
		super(exceptionMsg);
	}
	
}