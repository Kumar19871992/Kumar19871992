package com.ssnc.qcboost.dao;

import com.ssnc.stocktransfer.model.GetAgentRequest;
import com.ssnc.stocktransfer.model.GetAgentResponse;


 

public interface NameAgentDAO {
	GetAgentResponse getNameAgent(GetAgentRequest dataRequest);
}
