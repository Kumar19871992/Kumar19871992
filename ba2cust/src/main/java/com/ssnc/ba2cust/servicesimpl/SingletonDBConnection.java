package com.ssnc.ba2cust.servicesimpl;

import java.sql.Connection;
import java.sql.SQLException;
 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ssnc.ba2cust.exceptions.DataSourceNotAvailable;
 
public class SingletonDBConnection
{
  private static SingletonDBConnection singleInstance;
  private static DataSource dataSource;
  private static Connection dbConnect;
   
  private SingletonDBConnection()
  {
    try
    {
      Context initContext = new InitialContext();
      //Context envContext  = (Context) initContext.lookup("java:/comp/env");
      dataSource       = (DataSource) initContext.lookup("java:/jdbc/awddb");
       
      try
      {
        dbConnect  = dataSource.getConnection();
      }
      catch (SQLException e)
      {
    	e.printStackTrace();
        throw new DataSourceNotAvailable("SQL Exception");
        
        
      }  
    }
    catch (NamingException e)
    {
      e.printStackTrace();
      throw new DataSourceNotAvailable("JNDI Name is not found");
    }
  }
   
  public static SingletonDBConnection getInstance()
  {
    if(singleInstance == null)
    {
      synchronized (SingletonDBConnection.class)
      {
        if(singleInstance == null)
        {
          singleInstance = new SingletonDBConnection();
        }
      }
    }
 
    return singleInstance;
  }
   
  public static Connection getConnInst()
  {
    try
    {
      dbConnect = dataSource.getConnection();
    }
    catch (SQLException e1)
    {
      e1.printStackTrace();
    }
     
    if(dbConnect == null)
    {
      try
      {
    	  Context initContext = new InitialContext();
          //Context envContext  = (Context) initContext.lookup("java:/comp/env");
          dataSource       = (DataSource) initContext.lookup("java:/jdbc/awddb");
         
        try
        {
          dbConnect  = dataSource.getConnection();
        }
        catch (SQLException e)
        {
          e.printStackTrace();
        }  
      }
      catch (NamingException e)
      {
        e.printStackTrace();
        throw new DataSourceNotAvailable("JNDI Name is not found");
      }
    }
     
    return dbConnect;   
  }
}