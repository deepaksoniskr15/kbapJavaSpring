package com.lina.chat.app.dto;

import java.util.List;

public class IntentDetails {

	String key;

	String type;

	List<CbIntentParametersDto> textBoxLabelsAndMessages;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CbIntentParametersDto> getTextBoxLabelsAndMessages() {
		return textBoxLabelsAndMessages;
	}

	public void setTextBoxLabelsAndMessages(List<CbIntentParametersDto> textBoxLabelsAndMessages) {
		this.textBoxLabelsAndMessages = textBoxLabelsAndMessages;
	}

}
