package com.ssnc.ba2cust.servicesimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class GetCustomerImpl {
	//Connection conn = SingletonDBConnection.getConnInst();
	public GetCustomerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getData () throws SQLException, ClassNotFoundException, NamingException    {
		Connection conn = SingletonDBConnection.getInstance().getConnInst();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select CONFIG_VALUE from WM7U999S where CONFIG_PARM_NAME='BA2CUST_XML'");  
		String s =null;
		while(rs.next())  
			 
			s = rs.getString(1)  ;
		stmt.close();
		conn.close();
		return s;
	}
	public String getSourceTypes () throws SQLException, ClassNotFoundException, NamingException    {
		Connection conn = SingletonDBConnection.getInstance().getConnInst();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select CONFIG_VALUE from WM7U999S where CONFIG_PARM_NAME='SOURCETYPES_XML'");  
		String a =null;
		while(rs.next())  
			 
			a = rs.getString(1)  ;
		
		System.out.println(a);
		stmt.close();
		conn.close();
		return a;
	}
	public String getAwdBatchTypes () throws SQLException, ClassNotFoundException, NamingException    {
		Connection conn = SingletonDBConnection.getInstance().getConnInst();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select CONFIG_VALUE from WM7U999S where CONFIG_PARM_NAME='AWD_BATCH_USER'");  
		String b =null;
		while(rs.next())  
		{	 
			b = rs.getString(1)  ;
		}
		stmt.close();
		conn.close();
		return b;
	}
	public String getSpartn() throws SQLException, ClassNotFoundException, NamingException    {
		Connection conn = SingletonDBConnection.getInstance().getConnInst();
		String req = null;
		CallableStatement cstmt = conn.prepareCall("{  call ZSPSPARTN(?)}");
		
		cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
		cstmt.execute();
	    ResultSet resultSet = (ResultSet) cstmt.getObject(1);
        while (resultSet.next()) {
		  req = resultSet.getString("REQ");
        }
        cstmt.close();
        conn.close();
		return "<REQ>"+req+"</REQ>";
	}
}
