package com.lina.chat.app.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lina.chat.app.domain.ApInvoiceDetailsIntentData;
import com.lina.chat.app.dto.ApInvoiceDetailsIntentDataDto;

@Repository
@Transactional(readOnly = true)
public class ApInvoiceDetailsIntentDataRepositoryImpl implements ApInvoiceDetailsIntentDataRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<ApInvoiceDetailsIntentData> findBy(ApInvoiceDetailsIntentDataDto apInvoiceData) {
		String queryString = "select * from apinvoicedetailsintentdata where %condition%";
		String conditionQuery = "";
		if (apInvoiceData.getInvoiceNumber() != null && !apInvoiceData.getInvoiceNumber().equals("")) {
			conditionQuery += " invoice_number = '" + apInvoiceData.getInvoiceNumber() + "'";
		}
		if (apInvoiceData.getInvoiceDate() != null) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery += " invoice_date like '%" + apInvoiceData.getInvoiceDate() + "%'";
		}
		if (apInvoiceData.getSupplierName() != null && !apInvoiceData.getSupplierName().equals("")) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery += " supplier_name = '" + apInvoiceData.getSupplierName() + "'";
		}
		if (apInvoiceData.getSupplierNumber() != null && !apInvoiceData.getSupplierNumber().equals("")) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery = " supplier_number = '" + apInvoiceData.getSupplierNumber() + "'";
		}
		if (apInvoiceData.getGlDate() != null) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery += " gl_date like '%" + apInvoiceData.getGlDate() + "%'";
		}

		if (apInvoiceData.getPaymentNumber() != null && !apInvoiceData.getPaymentNumber().equals("")) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery += " payment_number = '" + apInvoiceData.getPaymentNumber() + "'";
		}
		if (apInvoiceData.getPaymentDate() != null) {
			if (!conditionQuery.equals("")) {
				conditionQuery += " and ";
			}
			conditionQuery += " payment_date like '%" + apInvoiceData.getPaymentDate() + "%'";
		}

		if (conditionQuery.equals("")) {
			return new ArrayList<ApInvoiceDetailsIntentData>();
		} else {
			queryString = queryString.replace("%condition%", conditionQuery);
		}
		Query query = entityManager.createNativeQuery(queryString, ApInvoiceDetailsIntentData.class);
		return query.getResultList();
	}
}