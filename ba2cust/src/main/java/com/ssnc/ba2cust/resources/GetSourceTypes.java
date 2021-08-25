package com.ssnc.ba2cust.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ssnc.ba2cust.services.GetCustomerDataService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("getSourceTypes")
public class GetSourceTypes {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws ClassNotFoundException 
     * @throws SQLException 
     * @throws NamingException 
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getIt() throws ClassNotFoundException, SQLException, NamingException {
    	
    	GetCustomerDataService getCustomerDataService = new GetCustomerDataService();
    	String data = getCustomerDataService.getSourceTypesData();
    	 
    	return Response.status(200).entity(data).header("Access-Control-Allow-Origin", "*")
    		      .header("Access-Control-Allow-Credentials", "true")
    		      .header("Access-Control-Allow-Headers",
    		        "origin, content-type, accept, authorization")
    		      .header("Access-Control-Allow-Methods", 
    		        "GET, POST, PUT, DELETE, OPTIONS, HEAD").build(); 
		//return null;
    }
    
    
}

 
 
