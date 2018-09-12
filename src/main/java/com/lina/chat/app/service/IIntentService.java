package com.lina.chat.app.service;

import java.util.List;

import com.lina.chat.app.domain.CbIntentParameters;
import com.lina.chat.app.dto.ApInvoiceDetailsIntentDataDto;
import com.lina.chat.app.dto.TableResponseData;

public interface IIntentService {

	List<CbIntentParameters> getIntentData(String key);

	String findIntentNameBy(String key);

	List<String> findUtteranceDescription();

	TableResponseData getTableDataByRequestParams(ApInvoiceDetailsIntentDataDto intentRequestDataDto);

}
