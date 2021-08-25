package com.ssnc.qcboost.dao;

import com.ssnc.awdqcboost.model.GetNameAccountRequest;
import com.ssnc.awdqcboost.model.GetNameAccountResponse;
 

public interface NameAccountDAO {
	GetNameAccountResponse getNameAccount(GetNameAccountRequest dataRequest);
	 
}
