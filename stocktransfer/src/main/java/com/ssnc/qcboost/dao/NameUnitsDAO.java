package com.ssnc.qcboost.dao;

import com.ssnc.stocktransfer.model.units.GetUnitsRequest;
import com.ssnc.stocktransfer.model.units.GetUnitsResponse;


 

public interface NameUnitsDAO {
	GetUnitsResponse getUnits(GetUnitsRequest dataRequest);
}
