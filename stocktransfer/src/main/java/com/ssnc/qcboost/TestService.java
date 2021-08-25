package com.ssnc.qcboost;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
 




import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
public class TestService {
 public static void main(String[] args)      {
  ClientConfig config = new DefaultClientConfig();
  Client client = Client.create(config);
  WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:5000/getNamePostCodeAcnNumb").build());
  MultivaluedMap formData = new MultivaluedMapImpl();
  formData.add("nameAddress", "michael rogers hall building 122 leaden hall street london 67808-8764 a/c 15068690");
   
  ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, formData);
 // System.out.println("Response " + response.getEntity(String.class));
  
  JSONObject resObj;
try {
	resObj = (JSONObject)new JSONParser().parse(response.getEntity(String.class));
	 System.out.println(resObj);
	      
	 System.out.println(resObj.get("Name"));
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
  //
 
 }
}