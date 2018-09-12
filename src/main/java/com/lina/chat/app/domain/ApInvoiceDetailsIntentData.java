package com.lina.chat.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lina.chat.app.config.CustomJsonDateSerializer;
import com.lina.chat.app.config.CustomerDateAndTimeDeserialize;

@Entity
@Table(name = "apinvoicedetailsintentdata")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
public class ApInvoiceDetailsIntentData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "invoiceNumber")
	private String invoiceNumber;

	@Column(name = "invoiceDate")
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date invoiceDate;

	@Column(name = "invoiceType")
	private String invoiceType;

	@Column(name = "supplierName")
	private String supplierName;

	@Column(name = "supplierNumber")
	private String supplierNumber;

	@Column(name = "invoiceAmount")
	private Double invoiceAmount;

	@Column(name = "glDate")
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date glDate;
	
	@Column(name = "paymentDate")
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date paymentDate;

	@Column(name = "paymentNumber")
	private String paymentNumber;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "bankAccountNum")
	private String bankAccountNum;

	@Column(name = "paymentAmount")
	private Double paymentAmount;
	
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Column(name = "timeStamp")
	private Date timeStamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}


	public Date getGlDate() {
		return glDate;
	}

	public void setGlDate(Date glDate) {
		this.glDate = glDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNum() {
		return bankAccountNum;
	}

	public void setBankAccountNum(String bankAccountNum) {
		this.bankAccountNum = bankAccountNum;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
