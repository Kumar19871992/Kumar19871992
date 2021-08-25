package com.ssnc.qcboost;

import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class JerseyClient {

    public static void main(String[] args) {

        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        // Jersey client POST example
        GetNameAccountRequest bookEntity = new GetNameAccountRequest();
        GetNameAccountResponse response = new GetNameAccountResponse();
        bookEntity.setNameAddress("michael rogers hall building 122 leaden hall street london 67808-8764 a/c 15068690");
        
        String postURL = "http://localhost:5000/getNamePostCodeAcnNumb";
        WebResource webResourcePost = client.resource(postURL);
        response = webResourcePost.type("application/json").post(GetNameAccountResponse.class, bookEntity);
          //response.getEntity(GetNameAccountResponse.class);

        //System.out.println(responseEntity.toString());
    }
}