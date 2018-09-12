package com.lina.chat.app.repository;

import java.util.List;

import com.lina.chat.app.domain.ApInvoiceDetailsIntentData;
import com.lina.chat.app.dto.ApInvoiceDetailsIntentDataDto;

public interface ApInvoiceDetailsIntentDataRepositoryCustom {
	
	public List<ApInvoiceDetailsIntentData> findBy(ApInvoiceDetailsIntentDataDto apInvoiceData);
}
