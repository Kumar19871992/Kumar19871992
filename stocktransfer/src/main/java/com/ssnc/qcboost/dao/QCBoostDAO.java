package com.ssnc.qcboost.dao;

import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;

public interface QCBoostDAO {
	GetDataResponse getData(GetDataRequest dataRequest);
	String callRest(QcBoostRequest boostRequest);
}
