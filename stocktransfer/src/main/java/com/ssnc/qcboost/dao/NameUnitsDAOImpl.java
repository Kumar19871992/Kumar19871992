package com.ssnc.qcboost.dao;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssnc.stocktransfer.model.units.GetUnitsRequest;
import com.ssnc.stocktransfer.model.units.GetUnitsResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Repository
public class NameUnitsDAOImpl implements NameUnitsDAO {
	private static final Logger logger = LoggerFactory.getLogger(NameUnitsDAOImpl.class);

	@Override
	public GetUnitsResponse getUnits(
			GetUnitsRequest dataRequest) {
		// TODO Auto-generated method stub
		
		logger.info("getUnits dao method called");
		GetUnitsResponse dataResponse = new GetUnitsResponse();
		 
		/*dataResponse.setAccountNumber("123");
		dataResponse.setName("Swamy");
		dataResponse.setPostalCode("505474");
		dataResponse.setType("PERSON");*/
		
		ClientConfig config = new DefaultClientConfig();
		  Client client = Client.create(config);
		  WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:5000/getUnits").build());
		  MultivaluedMap formData = new MultivaluedMapImpl();
		  formData.add("figure", dataRequest.getFigure());
		   
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
			      
			 //System.out.println(resObj.get("Name"));
			 dataResponse.setAmount(resObj.get("Amount").toString()); 
			 dataResponse.setG1(resObj.get("G1").toString()); 
			 dataResponse.setG2(resObj.get("G2").toString());
			 dataResponse.setTypeprocessing(resObj.get("TypeofProcessing").toString()); 
		return dataResponse;
	}
}
