package com.lina.chat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lina.chat.app.domain.CbIntentParameters;

@Repository
public interface CbIntentParametersRepository extends CrudRepository<CbIntentParameters, Long> {

	@Query(value = "select cbintentparameters.* from cbindtentutterances join cbintent using(intent_id) join cbintentparameters using(intent_id) where REPLACE(utterance_description,' ', '') = :utterance_description", nativeQuery = true)
	public List<CbIntentParameters> getIntentData(@Param("utterance_description") String utterance_description);
	
}
