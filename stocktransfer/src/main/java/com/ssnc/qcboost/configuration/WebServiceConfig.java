package com.ssnc.qcboost.configuration;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import com.ssnc.qcboost.AwdQCBoostApplication;
import com.ssnc.qcboost.error.QCBoostException;
import com.ssnc.qcboost.error.SoapExceptionResolver;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(AwdQCBoostApplication.class);

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "qcBoostServices")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection imageRetrievalSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ImageRetrievalImplementation");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://model.awdqcboost.ssnc.com");
		wsdl11Definition.setSchemaCollection(schemaCollection());
		return wsdl11Definition;
	}

	@Bean
	public XsdSchemaCollection schemaCollection() {
		CommonsXsdSchemaCollection commonsXsdSchemaCollection = new CommonsXsdSchemaCollection(
				 new ClassPathResource("getNameAccount.xsd"),new ClassPathResource("getNameAgent.xsd"),new ClassPathResource("getUnits.xsd") );
		commonsXsdSchemaCollection.setInline(true);
		return commonsXsdSchemaCollection;
	}

	@Bean
	public PayloadValidatingInterceptor payloadValidatingInterceptor() {
		final PayloadValidatingInterceptor payloadValidatingInterceptor = new PayloadValidatingInterceptor();
		payloadValidatingInterceptor.setValidateRequest(true);
		payloadValidatingInterceptor.setSchemas( new ClassPathResource("getNameAccount.xsd"),new ClassPathResource("getNameAgent.xsd"),new ClassPathResource("getUnits.xsd") );
		return payloadValidatingInterceptor;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(payloadValidatingInterceptor());
	}

	@Bean
	public SoapFaultMappingExceptionResolver exceptionHandler() {
		LOG.info("SoapFaultMappingExceptionResolver created");
		SoapFaultMappingExceptionResolver exceptionResolver = new SoapExceptionResolver();

		Properties errorMappings = new Properties();
		errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
		errorMappings.setProperty(QCBoostException.class.getName(), SoapFaultDefinition.SERVER.toString());
		exceptionResolver.setExceptionMappings(errorMappings);
		exceptionResolver.setOrder(1);
		return exceptionResolver;
	}
}