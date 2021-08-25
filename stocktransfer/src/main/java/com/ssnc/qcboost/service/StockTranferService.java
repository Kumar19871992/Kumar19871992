package com.ssnc.qcboost.service;

 
import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
import com.ssnc.stocktransfer.model.GetAgentRequest;
import com.ssnc.stocktransfer.model.GetAgentResponse;
import com.ssnc.stocktransfer.model.units.GetUnitsRequest;
import com.ssnc.stocktransfer.model.units.GetUnitsResponse;
 

public interface StockTranferService {
	GetNameAccountResponse callNameAccount(GetNameAccountRequest dataRequest);
	GetAgentResponse callNameAgent(GetAgentRequest dataagntRequest);
	GetUnitsResponse callUnits(GetUnitsRequest dataunistsRequest);
}
