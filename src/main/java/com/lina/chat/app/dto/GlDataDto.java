package com.lina.chat.app.dto;

import java.util.Date;

public class GlDataDto {

	private String invoiceNumber;

	private Date glDate;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getGlDate() {
		return glDate;
	}

	public void setGlDate(Date glDate) {
		this.glDate = glDate;
	}

}
