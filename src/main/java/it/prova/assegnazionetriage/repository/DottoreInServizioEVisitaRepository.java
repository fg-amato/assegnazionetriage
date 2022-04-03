package it.prova.assegnazionetriage.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.assegnazionetriage.model.DottoreInServizioEVisita;

public interface DottoreInServizioEVisitaRepository extends CrudRepository<DottoreInServizioEVisita, Long> {
	DottoreInServizioEVisita findByCodiceDipendente(String codiceDipendente);
}
