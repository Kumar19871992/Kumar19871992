//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.10 at 11:35:13 AM IST 
//


package com.ssnc.awdqcboost.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lob_call" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_amtv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_fund" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_vext" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_deal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_disc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unitcd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queuecd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_tapr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupcd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="categorycd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wrktype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lob_ltty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duration_max" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lobCall",
    "lobAmtv",
    "lobFund",
    "lobVext",
    "lobDeal",
    "lobDisc",
    "unitcd",
    "queuecd",
    "lobTapr",
    "groupcd",
    "categorycd",
    "userid",
    "wrktype",
    "lobLtty",
    "durationMax"
})
@XmlRootElement(name = "qcBoostRequest")
public class QcBoostRequest {

    @XmlElement(name = "lob_call", required = true, nillable = true)
    protected String lobCall;
    @XmlElement(name = "lob_amtv", required = true, nillable = true)
    protected String lobAmtv;
    @XmlElement(name = "lob_fund", required = true, nillable = true)
    protected String lobFund;
    @XmlElement(name = "lob_vext", required = true, nillable = true)
    protected String lobVext;
    @XmlElement(name = "lob_deal", required = true, nillable = true)
    protected String lobDeal;
    @XmlElement(name = "lob_disc", required = true, nillable = true)
    protected String lobDisc;
    @XmlElement(required = true, nillable = true)
    protected String unitcd;
    @XmlElement(required = true, nillable = true)
    protected String queuecd;
    @XmlElement(name = "lob_tapr", required = true, nillable = true)
    protected String lobTapr;
    @XmlElement(required = true, nillable = true)
    protected String groupcd;
    @XmlElement(required = true, nillable = true)
    protected String categorycd;
    @XmlElement(required = true, nillable = true)
    protected String userid;
    @XmlElement(required = true, nillable = true)
    protected String wrktype;
    @XmlElement(name = "lob_ltty", required = true, nillable = true)
    protected String lobLtty;
    @XmlElement(name = "duration_max", required = true, nillable = true)
    protected String durationMax;

    /**
     * Gets the value of the lobCall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobCall() {
        return lobCall;
    }

    /**
     * Sets the value of the lobCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobCall(String value) {
        this.lobCall = value;
    }

    /**
     * Gets the value of the lobAmtv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobAmtv() {
        return lobAmtv;
    }

    /**
     * Sets the value of the lobAmtv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobAmtv(String value) {
        this.lobAmtv = value;
    }

    /**
     * Gets the value of the lobFund property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobFund() {
        return lobFund;
    }

    /**
     * Sets the value of the lobFund property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobFund(String value) {
        this.lobFund = value;
    }

    /**
     * Gets the value of the lobVext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobVext() {
        return lobVext;
    }

    /**
     * Sets the value of the lobVext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobVext(String value) {
        this.lobVext = value;
    }

    /**
     * Gets the value of the lobDeal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobDeal() {
        return lobDeal;
    }

    /**
     * Sets the value of the lobDeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobDeal(String value) {
        this.lobDeal = value;
    }

    /**
     * Gets the value of the lobDisc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobDisc() {
        return lobDisc;
    }

    /**
     * Sets the value of the lobDisc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobDisc(String value) {
        this.lobDisc = value;
    }

    /**
     * Gets the value of the unitcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitcd() {
        return unitcd;
    }

    /**
     * Sets the value of the unitcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitcd(String value) {
        this.unitcd = value;
    }

    /**
     * Gets the value of the queuecd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueuecd() {
        return queuecd;
    }

    /**
     * Sets the value of the queuecd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueuecd(String value) {
        this.queuecd = value;
    }

    /**
     * Gets the value of the lobTapr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobTapr() {
        return lobTapr;
    }

    /**
     * Sets the value of the lobTapr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobTapr(String value) {
        this.lobTapr = value;
    }

    /**
     * Gets the value of the groupcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupcd() {
        return groupcd;
    }

    /**
     * Sets the value of the groupcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupcd(String value) {
        this.groupcd = value;
    }

    /**
     * Gets the value of the categorycd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorycd() {
        return categorycd;
    }

    /**
     * Sets the value of the categorycd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorycd(String value) {
        this.categorycd = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserid(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the wrktype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrktype() {
        return wrktype;
    }

    /**
     * Sets the value of the wrktype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrktype(String value) {
        this.wrktype = value;
    }

    /**
     * Gets the value of the lobLtty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLobLtty() {
        return lobLtty;
    }

    /**
     * Sets the value of the lobLtty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLobLtty(String value) {
        this.lobLtty = value;
    }

    /**
     * Gets the value of the durationMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurationMax() {
        return durationMax;
    }

    /**
     * Sets the value of the durationMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurationMax(String value) {
        this.durationMax = value;
    }

}