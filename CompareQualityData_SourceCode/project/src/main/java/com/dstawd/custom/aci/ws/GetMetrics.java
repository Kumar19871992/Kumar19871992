/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dstawd.custom.aci.ws;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DT214352
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.ws.BindingType;

import com.dstawd.custom.pojo.MatricsData;
import com.dstawd.custom.pojo.QualityData;

/**
 * Retrieve Quality data.
 */
// Ensure the targetNamespace is specified to ensure WebSphere generates the WSDL and schema properly.
@WebService
@SOAPBinding( style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED )
@BindingType( value = javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING )
public class GetMetrics
{

  /**
   * get Quality data from AWD tables and Machine learning data.
   *
   * @param awdKey – the AWD object key returns yes
   * @throws Exception
   */
  @WebMethod( operationName = "getMetrics" )

  public @WebResult( name = "metricsData", partName = "metricsData" ) List<MatricsData> getMetricsData( @WebParam( name = "startData" ) final String startDate,
                                                                                                        @WebParam( name = "endDate" ) final String endDate,
                                                                                                        @WebParam( name = "lobName" ) final String lobName ) throws Exception
  {

    List<MatricsData> metricsDataList = new ArrayList<MatricsData>();
    try
    {
      Context initContext = new InitialContext();
      DataSource dataSource = (DataSource)initContext.lookup( "java:/jdbc/awddb" );
      try
      {
        Connection dbConnect = dataSource.getConnection();
        Statement stmt = dbConnect.createStatement();
        String query = "select t1.crdattim,t1.recordcd,t1.crnode,t3.UNITCD,t3.WRKTYPE,t3.STATCD,t1.ORIGINAL_SAMPLING,t2.DATAVALUE as PREDICTED_SAMPLING,t3.FLAG QUALITY_DECISION,t1.WORK_TIME from (SELECT * FROM (SELECT  DISTINCT(W20.CRDATTIM),W20.RECORDCD,W20.CRNODE,CASE WHEN RTRIM(ENDQUEUECD)=RTRIM(QUEUECD) THEN 'Y' ELSE 'N' END ORIGINAL_SAMPLING,"
  +"(extract( day from (enddattim - begdattim) )*24 +"
        		  +"extract( hour from (enddattim - begdattim)) +"
        		  +" extract( minute from (enddattim - begdattim) )*0.0166667 +"
        		  +"extract( second from (enddattim - begdattim) )*0.000277778) AS WORK_TIME FROM AWDPOWNER.W20U999S W20 LEFT JOIN AWDPOWNER.W05U999S W05 "
        		  +" ON W20.ENDQUEUECD=W05.QUEUECD) A WHERE  A.CRDATTIM>=to_timestamp('"
                 + startDate
                 + "', 'dd-mon-yyyy hh24:mi:ss:ff' ) AND A.CRDATTIM<=to_timestamp( '"
                 + endDate
                 + "', 'dd-mon-yyyy hh24:mi:ss:ff' ) "
                 + ") t1,  "
                 + "(SELECT W01.crdattim,  "
                 + "       W01.recordcd,  "
                 + "       W01.crnode,  "
                 + "       CASE Rtrim(W01.datavalue)  "
                 + "         WHEN 'Y' THEN 'YES'  "
                 + "         WHEN 'N' THEN 'NO'  "
                 + "         ELSE datavalue  "
                 + "       END AS DATAVALUE  "
                 + "FROM   AWDPOWNER.w01u999s W01  "
                 + "WHERE  dataname = '"
                 + lobName
                 + "'  "
                 + "       AND W01.crdattim >= To_timestamp('"
                 + startDate
                 + "',  "
                 + "                           'dd-mon-yyyy hh24:mi:ss:ff')  "
                 + "       AND W01.crdattim <= To_timestamp('"
                 + endDate
                 + "',  "
                 + "                           'dd-mon-yyyy hh24:mi:ss:ff') "
                 + ") t2,( "
                 + "SELECT crdattim,  "
                 + "       unitcd,  "
                 + "       wrktype, statcd, "
                 + "       CASE  "
                 + "         WHEN Rtrim(errcd) IS NOT NULL THEN 'FAIL'  "
                 + "         ELSE 'PASS'  "
                 + "       END AS FLAG  "
                 + "FROM   (SELECT crdattim,  "
                 + "               unitcd,  "
                 + "               wrktype,  "
                 + "               statcd,  "
                 + "               revdattim,  "
                 + "               errcd,  "
                 + "               Row_number()  "
                 + "                 over (  "
                 + "                   PARTITION BY crdattim, unitcd, wrktype, statcd  "
                 + "                   ORDER BY revdattim DESC) AS row_num  "
                 + "        FROM   AWDPOWNER.w54u999s) a "
                 + "WHERE  a.row_num = 1  "
                 + "       AND A.crdattim >= To_timestamp('"
                 + startDate
                 + "',  "
                 + "                         'dd-mon-yyyy hh24:mi:ss:ff')  "
                 + "       AND A.crdattim <= To_timestamp('"
                 + endDate
                 + "',  "
                 + "                         'dd-mon-yyyy hh24:mi:ss:ff') "
                 + ") t3 "
                 + "where t1.crdattim = t2.crdattim and t2.crdattim=t3.crdattim";


        ResultSet rs = stmt.executeQuery( query );
        MatricsData metrics = new MatricsData();
        int totalWorkObjectscount =0;
        int OriginalSamplingN = 0;
        int OriginalSamplingY = 0;
          int predictedSamplingY= 0;
          int predictedSamplingN= 0;
          int qualityDecisionY= 0;
          int qualityDecisionN= 0;
        
        while ( rs.next() )
        {
        	totalWorkObjectscount++;
          QualityData qData = new QualityData();
          
          qData.setRecordcd( rs.getString( 2 ) );
          qData.setCrnode( rs.getString( 3 ) );

          qData.setUnitCode( rs.getString( 4 ) );
          qData.setWrkType( rs.getString( 5 ) );
          qData.setStatCode( rs.getString( 6 ) );
          qData.setOriginalSampling( rs.getString( 7 ) );

          qData.setPredictedSampling( rs.getString( 8 ) );
          qData.setQualityDecision( rs.getString( 9 ) );
          qData.setQcTime( rs.getString( 10 ) );
         // qualityDataList.add( qData );
          
          
          
          
         
          if("N".equals(rs.getString( 7 ))){
        	  OriginalSamplingN++;
          }
          else{
        	  OriginalSamplingY++;
          }

          if("NO".equals(rs.getString( 8 ))){
        	  predictedSamplingN++;
          }
          else{
        	  predictedSamplingY++;
          }
          if("FAIL".equals(rs.getString( 9 ))){
        	  qualityDecisionN++;
          }
          else{
        	  qualityDecisionY++;
          }
          
          
        }
        metrics.setTotalWorkObjectsProcessed(totalWorkObjectscount);
		metrics.setOriginalSamplingN(OriginalSamplingN);
		metrics.setOriginalSamplingY(OriginalSamplingY);
		
		metrics.setPredictedSamplingN(predictedSamplingN);
		metrics.setPredictedSamplingY(predictedSamplingY);
		
		metrics.setQualityDecisionN(qualityDecisionN);
		metrics.setQualityDecisionY(qualityDecisionY);
		
		metricsDataList.add(metrics);
		stmt.close();
	    dbConnect.close();
		return metricsDataList;
      }
      catch ( SQLException e )
      {
        e.printStackTrace();
      }
    }
    catch ( NamingException e )
    {
      e.printStackTrace();
    }
    
    return metricsDataList;
  }
}
