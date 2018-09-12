package com.lina.chat.app.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomerDateAndTimeDeserialize extends JsonDeserializer<Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();
		try {
			return dateFormat.parse(str);
		} catch (Exception e) {
		}
		return paramDeserializationContext.parseDate(str);
	}
}