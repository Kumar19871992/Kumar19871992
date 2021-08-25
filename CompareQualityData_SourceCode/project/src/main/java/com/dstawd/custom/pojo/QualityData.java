package com.dstawd.custom.pojo;

public class QualityData
{
  private String crdattim;
  private String recordcd;
  private String crnode;

  private String unitCode;
  private String wrkType;
  private String statCode;
  private String originalSampling;
  private String predictedSampling;
  private String qualityDecision;
  private String qcTime;

  public String getCrdattim()
  {
    return crdattim;
  }

  public void setCrdattim( String crdattim )
  {
    this.crdattim = crdattim;
  }

  public String getRecordcd()
  {
    return recordcd;
  }

  public void setRecordcd( String recordcd )
  {
    this.recordcd = recordcd;
  }

  public String getCrnode()
  {
    return crnode;
  }

  public void setCrnode( String crnode )
  {
    this.crnode = crnode;
  }
  public String getUnitCode()
  {
    return unitCode;
  }
  public void setUnitCode( String unitCode )
  {
    this.unitCode = unitCode;
  }
  public String getWrkType()
  {
    return wrkType;
  }
  public void setWrkType( String wrkType )
  {
    this.wrkType = wrkType;
  }
  public String getStatCode()
  {
    return statCode;
  }
  public void setStatCode( String statCode )
  {
    this.statCode = statCode;
  }

  public String getOriginalSampling()
  {
    return originalSampling;
  }

  public void setOriginalSampling( String originalSampling )
  {
    this.originalSampling = originalSampling;
  }

  public String getPredictedSampling()
  {
    return predictedSampling;
  }

  public void setPredictedSampling( String predictedSampling )
  {
    this.predictedSampling = predictedSampling;
  }

  public String getQualityDecision()
  {
    return qualityDecision;
  }

  public void setQualityDecision( String qualityDecision )
  {
    this.qualityDecision = qualityDecision;
  }

public String getQcTime() {
	return qcTime;
}

public void setQcTime(String qcTime) {
	this.qcTime = qcTime;
}
}
