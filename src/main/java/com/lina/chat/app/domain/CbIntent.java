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
@Table(name = "cbintent")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
public class CbIntent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intentId")
	private Long intentId;

	@Column(name = "intentName")
	private String intentName;

	@Column(name = "summaryMessage")
	private String summaryMessage;

	@Column(name = "sampleResponse")
	private String sampleResponse;
	
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Column(name = "timeStamp")
	private Date timeStamp;
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Long getIntentId() {
		return intentId;
	}

	public void setIntentId(Long intentId) {
		this.intentId = intentId;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public String getSummaryMessage() {
		return summaryMessage;
	}

	public void setSummaryMessage(String summaryMessage) {
		this.summaryMessage = summaryMessage;
	}

	public String getSampleResponse() {
		return sampleResponse;
	}

	public void setSampleResponse(String sampleResponse) {
		this.sampleResponse = sampleResponse;
	}
}
