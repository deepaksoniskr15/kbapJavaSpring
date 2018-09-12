package com.lina.chat.app.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lina.chat.app.domain.ApInvoiceDetailsIntentData;
import com.lina.chat.app.domain.CbIntentParameters;
import com.lina.chat.app.dto.ApInvoiceDetailsIntentDataDto;
import com.lina.chat.app.dto.TableResponseData;
import com.lina.chat.app.repository.ApInvoiceDetailsIntentDataRepository;
import com.lina.chat.app.repository.CbIndtentUtterancesRepository;
import com.lina.chat.app.repository.CbIntentParametersRepository;
import com.lina.chat.app.repository.CbIntentRepository;

@Service
public class IntentServiceImpl implements IIntentService {

	@Value("${intent.invoice.key}")
	public String invoiceDataKey;

	@Value("${intent.payment.key}")
	public String paymentDataKey;

	@Value("${intent.gl.date.key}")
	public String glDataKey;

	@Autowired
	CbIntentParametersRepository intentParametersRepository;

	@Autowired
	CbIndtentUtterancesRepository indtentUtterancesRepository;

	@Autowired
	CbIntentRepository intentRepository;

	@Autowired
	ApInvoiceDetailsIntentDataRepository apInvoiceDetailsRepository;

	@Override
	public List<CbIntentParameters> getIntentData(String key) {
		return intentParametersRepository.getIntentData(key);
	}

	@Override
	public String findIntentNameBy(String key) {
		return intentRepository.findIntentNameBy(key);
	}

	@Override
	public List<String> findUtteranceDescription() {
		return indtentUtterancesRepository.findUtteranceDescription();
	}

	@Override
	public TableResponseData getTableDataByRequestParams(ApInvoiceDetailsIntentDataDto intentRequestDataDto) {
		TableResponseData tableResponseData = null;
		if (intentRequestDataDto.getRequestedFor() != null && !intentRequestDataDto.getRequestedFor().equals("")) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String requestFor = intentRequestDataDto.getRequestedFor().toLowerCase().trim().replace(" ", "");
			List<ApInvoiceDetailsIntentData> invoiceData = apInvoiceDetailsRepository.findBy(intentRequestDataDto);
			if (invoiceData.size() > 0) {
				tableResponseData = new TableResponseData();
				if (requestFor.equals(invoiceDataKey)) {
					String headerString = "Invoice Number,Invoice Date,Invoice Type,Supplier Name,Supplier Number,Invoice Amount,Gl Date";
					addHeaders(tableResponseData.getHeaders(), headerString);
					addValuesForInvoiceData(tableResponseData.getValues(), invoiceData, formatter);
					tableResponseData.setTableName(intentRequestDataDto.getRequestedFor());
				} else if (requestFor.equals(paymentDataKey)) {
					String headerString = "payment_date,payment_number,bank_name,bank_account_num,payment_amount,gl_date,invoice_number";
					addHeaders(tableResponseData.getHeaders(), headerString);
					addValuesForPaymentData(tableResponseData.getValues(), invoiceData, formatter);
					tableResponseData.setTableName(intentRequestDataDto.getRequestedFor());
				} else if (requestFor.equals(glDataKey)) {
					String headerString = "invoice_number,gl_date";
					addHeaders(tableResponseData.getHeaders(), headerString);
					addValuesForGlData(tableResponseData.getValues(), invoiceData, formatter);
					tableResponseData.setTableName(intentRequestDataDto.getRequestedFor());
				}
			}
		}
		return tableResponseData;
	}

	private void addValuesForGlData(List<Map<Integer, String>> values, List<ApInvoiceDetailsIntentData> invoiceData,
			Format formatter) {
		for (ApInvoiceDetailsIntentData apInvoiceDetailsIntentData : invoiceData) {
			Map<Integer, String> valueMap = new HashMap<Integer, String>();
			valueMap.put(0, apInvoiceDetailsIntentData.getInvoiceNumber());
			valueMap.put(1, formatter.format(apInvoiceDetailsIntentData.getGlDate()));
			values.add(valueMap);
		}
	}

	private void addValuesForPaymentData(List<Map<Integer, String>> values,
			List<ApInvoiceDetailsIntentData> invoiceData, Format formatter) {
		for (ApInvoiceDetailsIntentData apInvoiceDetailsIntentData : invoiceData) {
			Map<Integer, String> valueMap = new HashMap<Integer, String>();
			valueMap.put(0, formatter.format(apInvoiceDetailsIntentData.getPaymentDate()));
			valueMap.put(1, apInvoiceDetailsIntentData.getPaymentNumber());
			valueMap.put(2, apInvoiceDetailsIntentData.getBankName());
			valueMap.put(3, apInvoiceDetailsIntentData.getBankAccountNum());
			valueMap.put(4, String.valueOf(apInvoiceDetailsIntentData.getPaymentAmount()));
			valueMap.put(5, formatter.format(apInvoiceDetailsIntentData.getGlDate()));
			valueMap.put(6, apInvoiceDetailsIntentData.getInvoiceNumber());
			values.add(valueMap);
		}
	}

	private void addValuesForInvoiceData(List<Map<Integer, String>> values,
			List<ApInvoiceDetailsIntentData> invoiceData, Format formatter) {
		for (ApInvoiceDetailsIntentData apInvoiceDetailsIntentData : invoiceData) {
			Map<Integer, String> valueMap = new HashMap<Integer, String>();
			valueMap.put(0, apInvoiceDetailsIntentData.getInvoiceNumber());
			valueMap.put(1, formatter.format(apInvoiceDetailsIntentData.getInvoiceDate()));
			valueMap.put(2, apInvoiceDetailsIntentData.getInvoiceType());
			valueMap.put(3, apInvoiceDetailsIntentData.getSupplierName());
			valueMap.put(4, apInvoiceDetailsIntentData.getSupplierNumber());
			valueMap.put(5, String.valueOf(apInvoiceDetailsIntentData.getInvoiceAmount()));
			valueMap.put(6, formatter.format(apInvoiceDetailsIntentData.getGlDate()));
			values.add(valueMap);
		}
	}

	public void addHeaders(Map<Integer, String> headers, String headerString) {
		String[] headersArray = headerString.split(",");
		int count = 0;
		for (String string : headersArray) {
			headers.put(count, string);
			count++;
		}
	}

}
