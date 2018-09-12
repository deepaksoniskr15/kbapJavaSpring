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
@Table(name = "cbauditlog")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties
public class CbAuditLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId")
	private Long auditId;

	@Column(name = "auditDate")
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	private Date auditDate;
	
	@Column(name = "clientCode")
	private String clientCode;
	
	@Column(name = "userCode")
	private String userCode;
	
	@Column(name = "auditMessage")
	private String auditMessage;
	
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

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAuditMessage() {
		return auditMessage;
	}

	public void setAuditMessage(String auditMessage) {
		this.auditMessage = auditMessage;
	}

}
