package it.prova.assegnazionetriage.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.assegnazionetriage.controller.api.exceptions.DottoreNotFoundException;
import it.prova.assegnazionetriage.controller.api.exceptions.IdNotNullForInsertException;
import it.prova.assegnazionetriage.dto.DottoreInServizioEVisitaDTO;
import it.prova.assegnazionetriage.model.DottoreInServizioEVisita;
import it.prova.assegnazionetriage.service.DottoreInServizioEVisitaService;

@RestController
@RequestMapping("/api/assegnaDottore")
public class AssegnazioneDottore {
	@Autowired
	private DottoreInServizioEVisitaService dottoreConIdPazienteService;

	@GetMapping("/verifica/{cd}")
	public DottoreInServizioEVisitaDTO findById(@PathVariable(value = "cd", required = true) String cdInput) {
		DottoreInServizioEVisita dottore = dottoreConIdPazienteService.caricaPerCd(cdInput);

		if (dottore == null)
			throw new DottoreNotFoundException("Dottore not found con cd: " + cdInput);
		return DottoreInServizioEVisitaDTO.buildDottoreConIdPazienteDTOFromModel(dottore);
	}

	@GetMapping
	public List<DottoreInServizioEVisitaDTO> getAll() {
		return DottoreInServizioEVisitaDTO
				.createDottoreConIdPazienteDTOListFromModelList(dottoreConIdPazienteService.listAll());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DottoreInServizioEVisitaDTO createNew(@RequestBody DottoreInServizioEVisitaDTO input) {
		// ANDREBBE GESTITA CON ADVICE!!!
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (input.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		DottoreInServizioEVisita newEntry = input.buildDottoreConIdPazienteModel();
		// andrebbe in un service!!!

		DottoreInServizioEVisitaDTO result = DottoreInServizioEVisitaDTO
				.buildDottoreConIdPazienteDTOFromModel(dottoreConIdPazienteService.inserisciNuovo(newEntry));
		return result;
	}

	@PostMapping("/impostaInVisita")
	@ResponseStatus(HttpStatus.OK)
	public DottoreInServizioEVisitaDTO visita(@RequestBody String input) {
		DottoreInServizioEVisita dottore = dottoreConIdPazienteService.mettiInVisita(input);

		if (!dottore.getInVisita()) {
			throw new RuntimeException("PICCOLO PROBLEMINO");
		}
		return DottoreInServizioEVisitaDTO.buildDottoreConIdPazienteDTOFromModel(dottore);
	}

}
