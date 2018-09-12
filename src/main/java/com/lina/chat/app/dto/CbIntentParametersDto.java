package com.lina.chat.app.dto;

public class CbIntentParametersDto {

	private String textBoxName;

	private String textBoxLabel;

	private String placeholder;

	public String getTextBoxName() {
		return textBoxName;
	}

	public void setTextBoxName(String textBoxName) {
		this.textBoxName = textBoxName.replace(" ", "").trim();
	}

	public String getTextBoxLabel() {
		return textBoxLabel;
	}

	public void setTextBoxLabel(String textBoxLabel) {
		this.textBoxLabel = textBoxLabel;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

}
