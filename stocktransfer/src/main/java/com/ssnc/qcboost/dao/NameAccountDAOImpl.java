package com.ssnc.qcboost.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;
import com.ssnc.awdqcboost.model.QcBoostResponse;
import com.ssnc.qcboost.error.QCBoostException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Repository
public class NameAccountDAOImpl implements NameAccountDAO {
	private static final Logger logger = LoggerFactory.getLogger(NameAccountDAOImpl.class);

	@Override
	public GetNameAccountResponse getNameAccount(
			GetNameAccountRequest dataRequest) {
		// TODO Auto-generated method stub
		
		logger.info("getData dao method called");
		GetNameAccountResponse dataResponse = new GetNameAccountResponse();
		 
		/*dataResponse.setAccountNumber("123");
		dataResponse.setName("Swamy");
		dataResponse.setPostalCode("505474");
		dataResponse.setType("PERSON");*/
		
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:5000/getNamePostCodeAcnNumb").build());
		  MultivaluedMap formData = new MultivaluedMapImpl();
		  formData.add("nameAddress", dataRequest.getNameAddress());
		   
		  ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, formData);
		 // System.out.println("Response " + response.getEntity(String.class));
		  
		  JSONObject resObj = null;
		 
			try {
				resObj = (JSONObject)new JSONParser().parse(response.getEntity(String.class));
			} catch (ClientHandlerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UniformInterfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //System.out.println(resObj);
			      
			 System.out.println(resObj.get("Name"));
			 dataResponse.setName(resObj.get("Name").toString());
			 dataResponse.setAccountNumber(resObj.get("AccountNumber").toString());
			 dataResponse.setPostalCode(resObj.get("PostalCode").toString());
			 dataResponse.setType(resObj.get("Type").toString());
		return dataResponse;
	}
}
