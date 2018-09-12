package com.lina.chat.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lina.chat.app.domain.CbClient;

@Repository
public interface CbIntentRepository extends CrudRepository<CbClient, Long> {
	
	@Query(value = "select cbintent.intent_name from cbindtentutterances join cbintent using(intent_id) where REPLACE(utterance_description,' ', '') = :utterance_description", nativeQuery = true)
	public String findIntentNameBy(@Param("utterance_description") String utterance_description);
	
}
