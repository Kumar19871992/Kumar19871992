package com.ssnc.qcboost.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ssnc.awdqcboost.model.GetDataRequest;
import com.ssnc.awdqcboost.model.GetDataResponse;
import com.ssnc.awdqcboost.model.QcBoostRequest;
import com.ssnc.awdqcboost.model.QcBoostResponse;
import com.ssnc.qcboost.error.QCBoostException;

@Repository
public class QCBoostDAOImpl implements QCBoostDAO {
	private static final Logger logger = LoggerFactory.getLogger(QCBoostDAOImpl.class);

	@Override
	public GetDataResponse getData(GetDataRequest dataRequest) {
		logger.info("getData dao method called");
		GetDataResponse dataResponse = new GetDataResponse();
		Connection dbConnect = getConnection();
		logger.info("got the connection");
		if (dbConnect != null) {
			Statement stmt;
			try {
				stmt = dbConnect.createStatement();
				logger.info("statement created");
				String query = "select extract( day from diff )*24 + extract( hour from diff) + extract( minute from diff )*0.0166667 + extract( second from diff )*0.000277778"
								+ " from (select max(enddattim - begdattim) as diff from W20U999S where CRDATTIM =TO_TIMESTAMP("
								 ;
				ResultSet rs = stmt.executeQuery(query);
                String s = null;
        		logger.info("query " + query + " : executed");
                while (rs.next()) {
                    s = rs.getString(1);
                }
                if (s == null || s.length() == 0) {
            		logger.info("no response from DB");
                	dataResponse.setError("no data");
                }else{
                	dataResponse.setDuration(s);
                }
                stmt.close();
                dbConnect.close();
        		logger.info("Connection got closed");
			} catch (SQLException e) {
				throw new QCBoostException(e.getErrorCode(),  e.getMessage());
			}
		}
		return dataResponse;
	}

	@Override
	public String callRest(QcBoostRequest boostRequest) {
		logger.info("callRest dao method called");
        Connection dbConnect = getConnection();
        logger.info("connection created");
        Statement stmt;
        String s = null;
		try {
			stmt = dbConnect.createStatement();
			logger.info("statement created");
			String query = "select CONFIG_VALUE from WM7U999S where CONFIG_PARM_NAME='QCBOOSTURL'";
	        ResultSet rs = stmt.executeQuery(query);
	        logger.info("Query "+ query + " executed");
			while (rs.next()) {
	            s = rs.getString(1);
	        }
	        if (s == null || s.length() == 0) {
	        	logger.info("no url configured in WM7U999S");
	        }
	        stmt.close();
	        dbConnect.close();
	        logger.info("Connection got closed");
		} catch (SQLException e) {
			throw new QCBoostException(e.getErrorCode(),  e.getMessage());
		}
		return s;
	}

	private Connection getConnection() {
		logger.info("getting connection");
		Connection connection = null;
		try {
			Context initContext = new InitialContext();
			logger.info("InitialContext created");
			DataSource dataSource = (DataSource) initContext.lookup("java:/jdbc/awddb");
			logger.info("DataSource created");
			connection = dataSource.getConnection();
			logger.info("got the connection");
		} catch (Exception e) {
			throw new QCBoostException(500, e.getMessage());
		}
		return connection;
	}
}
