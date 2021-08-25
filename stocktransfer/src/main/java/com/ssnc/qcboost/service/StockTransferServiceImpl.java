package com.ssnc.qcboost.service;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
import com.ssnc.qcboost.dao.NameAccountDAO;
import com.ssnc.qcboost.dao.NameAgentDAO;
import com.ssnc.qcboost.dao.NameUnitsDAO;
import com.ssnc.stocktransfer.model.GetAgentRequest;
import com.ssnc.stocktransfer.model.GetAgentResponse;
import com.ssnc.stocktransfer.model.units.GetUnitsRequest;
import com.ssnc.stocktransfer.model.units.GetUnitsResponse;

@Service
public class StockTransferServiceImpl implements StockTranferService {
	
	@Autowired
	NameAccountDAO nameAccountDAO;
	
	@Autowired
	NameAgentDAO nameAgentDAO;
	
	@Autowired
	NameUnitsDAO nameUnitsDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(QCBoostServiceImpl.class);

	 

	@Override
	public GetNameAccountResponse callNameAccount(
			GetNameAccountRequest dataRequest) {
		// TODO Auto-generated method stub
		logger.info("callRest service method called");
		GetNameAccountResponse serviceResponse = nameAccountDAO.getNameAccount(dataRequest);
		//GetNameAccountResponse serviceResponse = new GetNameAccountResponse();
		//add validation logic
		
		return serviceResponse;
		 
	}
	
	@Override
	public GetAgentResponse callNameAgent(
			GetAgentRequest dataagntRequest) {
		// TODO Auto-generated method stub
		logger.info("callRest service method called");
		GetAgentResponse serviceResponse = nameAgentDAO.getNameAgent(dataagntRequest);
		 
		//add validation logic
		 
		return serviceResponse;
		 
	}
	
	@Override
	public GetUnitsResponse callUnits(
			GetUnitsRequest dataagntRequest) {
		// TODO Auto-generated method stub
		logger.info("callRest service method called");
		GetUnitsResponse serviceResponse = nameUnitsDAO.getUnits(dataagntRequest);
		 
		//add validation logic
		 
		return serviceResponse;
		 
	}
}