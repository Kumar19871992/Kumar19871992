package com.ssnc.ba2cust.servicesimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ssnc.ba2cust.exceptions.DataSourceNotAvailable;

public class GetDBConnection {
 Connection getDatabaseConnection() throws SQLException   {
	 
	/* try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@10.193.247.156:1521/XEPDB1","awdpowner","awd");  
		Statement stmt=con.createStatement();
		return stmt;*/
	 Connection connection = null;
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		InitialContext ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataSource ds;
		try {
			ds = (DataSource) ctx.lookup("java:/jdbc/awdcustom");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataSourceNotAvailable("Data source not available in database");
		}
		connection = ds.getConnection();
		//Statement stmt=connection.createStatement();
		return connection; 
		 
 }
}
