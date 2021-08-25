package com.ssnc.qcboost.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;
import com.ssnc.awdqcboost.model.QcBoostResponse;
import com.ssnc.qcboost.dao.QCBoostDAO;

@Service
public class QCBoostServiceImpl implements QCBoostService {
	
	@Autowired
	QCBoostDAO qcBoostDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(QCBoostServiceImpl.class);

	@Override
	public GetDataResponse getData(GetDataRequest dataRequest) {
		logger.info("getData service method called");
		//add validation logic
		return qcBoostDAO.getData(dataRequest);
	}

	@Override
	public QcBoostResponse callRest(QcBoostRequest boostRequest) {
		logger.info("callRest service method called");
		QcBoostResponse boostResponse = new QcBoostResponse();
		//add validation logic
		String url = qcBoostDAO.callRest(boostRequest);
		if(StringUtils.isNotEmpty(url)){
			//add logic to call rest service
		}
		return boostResponse;
	}
}
