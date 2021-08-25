package com.ssnc.qcboost.error;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

public class SoapExceptionResolver extends SoapFaultMappingExceptionResolver {

	private static final QName CODE = new QName("statusCode");
	private static final QName MESSAGE = new QName("message");

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		logger.warn("Exception processed ", ex);
		if (ex instanceof QCBoostException) {
			QCBoostException deException = (QCBoostException)ex;
			SoapFaultDetail detail = fault.addFaultDetail();
			detail.addFaultDetailElement(CODE).addText(deException.getErrorCode()+"");
			detail.addFaultDetailElement(MESSAGE).addText(deException.getErrorMessage());
		}
	}
}
