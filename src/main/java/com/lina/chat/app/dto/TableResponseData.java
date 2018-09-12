package com.lina.chat.app.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableResponseData {

	private String tableName;

	private Map<Integer, String> headers = new HashMap<Integer, String>();

	private List<Map<Integer, String>> values = new ArrayList<Map<Integer, String>>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<Integer, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<Integer, String> headers) {
		this.headers = headers;
	}

	public List<Map<Integer, String>> getValues() {
		return values;
	}

	public void setValues(List<Map<Integer, String>> values) {
		this.values = values;
	}

}
