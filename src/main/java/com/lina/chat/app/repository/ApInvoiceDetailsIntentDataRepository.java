package com.lina.chat.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lina.chat.app.domain.ApInvoiceDetailsIntentData;

@Repository
public interface ApInvoiceDetailsIntentDataRepository
		extends CrudRepository<ApInvoiceDetailsIntentData, Long>, ApInvoiceDetailsIntentDataRepositoryCustom {

}
