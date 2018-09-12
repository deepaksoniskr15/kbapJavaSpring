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
@Table(name = "cbindtentutterances")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
public class CbIndtentUtterances implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utteranceId")
	private Long utteranceId;

	@Column(name = "utteranceDescription")
	private String utteranceDescription;

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


	public Long getUtteranceId() {
		return utteranceId;
	}

	public void setUtteranceId(Long utteranceId) {
		this.utteranceId = utteranceId;
	}

	public String getUtteranceDescription() {
		return utteranceDescription;
	}

	public void setUtteranceDescription(String utteranceDescription) {
		this.utteranceDescription = utteranceDescription;
	}

	public Long getIntentId() {
		return intentId;
	}

	public void setIntentId(Long intentId) {
		this.intentId = intentId;
	}
	
}
