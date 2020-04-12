//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.07 at 11:56:08 AM EEST 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lot"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startedPrice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="currentPrice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="finalPrice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="lotStatus" type="{http://spring.io/guides/gs-producing-web-service}lotStatus"/&gt;
 *         &lt;element name="lotOwner" type="{http://spring.io/guides/gs-producing-web-service}user"/&gt;
 *         &lt;element name="offer" type="{http://spring.io/guides/gs-producing-web-service}offer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lot", propOrder = {
    "id",
    "startedPrice",
    "currentPrice",
    "finalPrice",
    "lotStatus",
    "lotOwner",
    "offer"
})
public class Lot {

    @XmlElement(required = true)
    protected String id;
    protected int startedPrice;
    protected int currentPrice;
    protected int finalPrice;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected LotStatus lotStatus;
    @XmlElement(required = true)
    protected User lotOwner;
    @XmlElement(required = true)
    protected Offer offer;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the startedPrice property.
     * 
     */
    public int getStartedPrice() {
        return startedPrice;
    }

    /**
     * Sets the value of the startedPrice property.
     * 
     */
    public void setStartedPrice(int value) {
        this.startedPrice = value;
    }

    /**
     * Gets the value of the currentPrice property.
     * 
     */
    public int getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets the value of the currentPrice property.
     * 
     */
    public void setCurrentPrice(int value) {
        this.currentPrice = value;
    }

    /**
     * Gets the value of the finalPrice property.
     * 
     */
    public int getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the value of the finalPrice property.
     * 
     */
    public void setFinalPrice(int value) {
        this.finalPrice = value;
    }

    /**
     * Gets the value of the lotStatus property.
     * 
     * @return
     *     possible object is
     *     {@link LotStatus }
     *     
     */
    public LotStatus getLotStatus() {
        return lotStatus;
    }

    /**
     * Sets the value of the lotStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link LotStatus }
     *     
     */
    public void setLotStatus(LotStatus value) {
        this.lotStatus = value;
    }

    /**
     * Gets the value of the lotOwner property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getLotOwner() {
        return lotOwner;
    }

    /**
     * Sets the value of the lotOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setLotOwner(User value) {
        this.lotOwner = value;
    }

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link Offer }
     *     
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offer }
     *     
     */
    public void setOffer(Offer value) {
        this.offer = value;
    }

}
