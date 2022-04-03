package it.prova.assegnazionetriage.service;

import java.util.List;

import it.prova.assegnazionetriage.model.DottoreInServizioEVisita;

public interface DottoreInServizioEVisitaService {
	public DottoreInServizioEVisita caricaPerCd(String cdInput);

	public DottoreInServizioEVisita inserisciNuovo(DottoreInServizioEVisita transientInstance);

	public List<DottoreInServizioEVisita> listAll();

	public DottoreInServizioEVisita mettiInVisita(String codiceDipendente);
}
