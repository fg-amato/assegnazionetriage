package it.prova.assegnazionetriage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.assegnazionetriage.model.DottoreInServizioEVisita;
import it.prova.assegnazionetriage.repository.DottoreInServizioEVisitaRepository;

@Service
public class DottoreInServizioEVisitaServiceImpl implements DottoreInServizioEVisitaService {

	@Autowired
	private DottoreInServizioEVisitaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public DottoreInServizioEVisita caricaPerCd(String cdInput) {
		return repository.findByCodiceDipendente(cdInput);
	}

	@Override
	@Transactional
	public DottoreInServizioEVisita inserisciNuovo(DottoreInServizioEVisita transientInstance) {
		transientInstance.setInServizio(true);
		transientInstance.setInVisita(false);
		return repository.save(transientInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DottoreInServizioEVisita> listAll() {
		return (List<DottoreInServizioEVisita>) repository.findAll();
	}

	@Override
	public DottoreInServizioEVisita mettiInVisita(String codiceDipendente) {

		DottoreInServizioEVisita dottore = repository.findByCodiceDipendente(codiceDipendente);

		dottore.setInServizio(true);
		dottore.setInVisita(true);

		return repository.save(dottore);
	}

}
