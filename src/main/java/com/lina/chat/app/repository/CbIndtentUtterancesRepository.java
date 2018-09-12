package com.lina.chat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lina.chat.app.domain.CbIndtentUtterances;

@Repository
public interface CbIndtentUtterancesRepository extends CrudRepository<CbIndtentUtterances, Long> {

	@Query(value = "select utterance_description from cbindtentutterances", nativeQuery = true)
	public List<String> findUtteranceDescription();

}
