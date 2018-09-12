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
@Table(name = "cbintentparameters")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
public class CbIntentParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parameterId")
	private Long parameterId;

	@Column(name = "parameterName")
	private String parameterName;

	@Column(name = "parameterDataType")
	private String parameterDataType;

	@Column(name = "parameterlength")
	private String parameterlength;

	@Column(name = "parameterPrompt")
	private String parameterPrompt;

	@Column(name = "intentId")
	private Long intentId;

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

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterDataType() {
		return parameterDataType;
	}

	public void setParameterDataType(String parameterDataType) {
		this.parameterDataType = parameterDataType;
	}

	public String getParameterlength() {
		return parameterlength;
	}

	public void setParameterlength(String parameterlength) {
		this.parameterlength = parameterlength;
	}

	public String getParameterPrompt() {
		return parameterPrompt;
	}

	public void setParameterPrompt(String parameterPrompt) {
		this.parameterPrompt = parameterPrompt;
	}

	public Long getIntentId() {
		return intentId;
	}

	public void setIntentId(Long intentId) {
		this.intentId = intentId;
	}
	
}
