package com.ssnc.qcboost.service;

import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;
import com.ssnc.awdqcboost.model.QcBoostResponse;

public interface QCBoostService {
	GetDataResponse getData(GetDataRequest dataRequest);
	QcBoostResponse callRest(QcBoostRequest boostRequest);
	//callPostalCode();
}
