package com.ssnc.qcboost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwdQCBoostApplication {

	private static final Logger logger = LoggerFactory.getLogger(AwdQCBoostApplication.class);

	public static void main(String[] args) {
		logger.info("AwdQCBoostApplication starting");
		SpringApplication.run(AwdQCBoostApplication.class, args);
		logger.info("AwdQCBoostApplication started");
	}
}
