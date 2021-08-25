package com.ssnc.qcboost.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

 




import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;
import com.ssnc.awdqcboost.model.QcBoostResponse;
import com.ssnc.qcboost.error.QCBoostException;
import com.ssnc.qcboost.service.StockTranferService;
import com.ssnc.stocktransfer.model.GetAgentRequest;
import com.ssnc.stocktransfer.model.GetAgentResponse;
import com.ssnc.stocktransfer.model.units.GetUnitsRequest;
import com.ssnc.stocktransfer.model.units.GetUnitsResponse;
 
 

@Endpoint
public class SoapServices {

	private static final Logger logger = LoggerFactory.getLogger(SoapServices.class);
	
	private static final String NAMESPACE_URI = "http://model.awdqcboost.ssnc.com";
	private static final String NAMESPACE_AGENT = "http://model.stocktransfer.ssnc.com";
	private static final String NAMESPACE_UNITS = "http://units.model.stocktransfer.ssnc.com";
	
	 
	
	@Autowired
	StockTranferService stkService;
	
	 
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameAccountRequest")
	@ResponsePayload
	public GetNameAccountResponse callNameAccount(@RequestPayload GetNameAccountRequest request) throws QCBoostException{
		logger.info("callRest soap service called");
		return stkService.callNameAccount(request);
	}

	@PayloadRoot(namespace = NAMESPACE_AGENT, localPart = "getAgentRequest")
	@ResponsePayload
	public GetAgentResponse callNameAgent(@RequestPayload GetAgentRequest agentrequest) throws QCBoostException{
		logger.info("callRest soap service called");
		return stkService.callNameAgent(agentrequest);
	}
	
	@PayloadRoot(namespace = NAMESPACE_UNITS, localPart = "getUnitsRequest")
	@ResponsePayload
	public GetUnitsResponse callUnits(@RequestPayload GetUnitsRequest agentrequest) throws QCBoostException{
		logger.info("callRest soap service called");
		return stkService.callUnits(agentrequest);
	}
}
