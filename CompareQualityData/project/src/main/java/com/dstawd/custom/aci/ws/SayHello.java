package com.dstawd.custom.aci.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import com.dstawd.custom.pojo.MatricsData;

@WebService
@SOAPBinding( style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED )
@BindingType( value = javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING )
public class SayHello {
	@WebMethod( operationName = "nameAddress" )

	  public @WebResult( name = "metricsData") String getMetricsData( @WebParam( name = "startData" ) final String nameAddress  ) throws Exception
	  {
		return nameAddress;
	  }
	  }
 
