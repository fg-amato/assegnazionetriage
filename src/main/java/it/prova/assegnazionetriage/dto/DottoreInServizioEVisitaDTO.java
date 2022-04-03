package it.prova.assegnazionetriage.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.assegnazionetriage.model.DottoreInServizioEVisita;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DottoreInServizioEVisitaDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceDipendente;
	private Boolean inServizio;
	private Boolean inVisita;

	public DottoreInServizioEVisitaDTO() {
		super();
	}

	public DottoreInServizioEVisitaDTO(String nome, String cognome, String codiceDipendente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public DottoreInServizioEVisitaDTO(Long id, String nome, String cognome, String codiceDipendente) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public DottoreInServizioEVisitaDTO(String nome, String cognome, String codiceDipendente,
			Long idPazienteAttualmenteInVisita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public DottoreInServizioEVisitaDTO(Long id, String nome, String cognome, String codiceDipendente,
			Long idPazienteAttualmenteInVisita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
	}

	public DottoreInServizioEVisitaDTO(String nome, String cognome, String codiceDipendente, Boolean inServizio,
			Boolean inVisita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public DottoreInServizioEVisitaDTO(Long id, String nome, String cognome, String codiceDipendente, Boolean inServizio,
			Boolean inVisita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDipendente = codiceDipendente;
		this.inServizio = inServizio;
		this.inVisita = inVisita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceDipendente() {
		return codiceDipendente;
	}

	public void setCodiceDipendente(String codiceDipendente) {
		this.codiceDipendente = codiceDipendente;
	}

	public Boolean getInServizio() {
		return inServizio;
	}

	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}

	public Boolean getInVisita() {
		return inVisita;
	}

	public void setInVisita(Boolean inVisita) {
		this.inVisita = inVisita;
	}

	public DottoreInServizioEVisita buildDottoreConIdPazienteModel() {
		return new DottoreInServizioEVisita(this.id, this.nome, this.cognome, this.codiceDipendente, this.inServizio,
				this.inVisita);
	}

	public static DottoreInServizioEVisitaDTO buildDottoreConIdPazienteDTOFromModel(DottoreInServizioEVisita dottoreModel) {
		DottoreInServizioEVisitaDTO result = new DottoreInServizioEVisitaDTO(dottoreModel.getId(), dottoreModel.getNome(),
				dottoreModel.getCognome(), dottoreModel.getCodiceDipendente(), dottoreModel.getInServizio(),
				dottoreModel.getInVisita());
		return result;
	}

	public static List<DottoreInServizioEVisitaDTO> createDottoreConIdPazienteDTOListFromModelList(
			List<DottoreInServizioEVisita> list) {
		return list.stream().map(dottoreEntity -> {
			DottoreInServizioEVisitaDTO result = DottoreInServizioEVisitaDTO
					.buildDottoreConIdPazienteDTOFromModel(dottoreEntity);
			return result;
		}).collect(Collectors.toList());
	}
}
