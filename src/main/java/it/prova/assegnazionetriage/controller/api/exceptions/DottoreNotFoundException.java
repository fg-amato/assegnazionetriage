package it.prova.assegnazionetriage.controller.api.exceptions;

public class DottoreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DottoreNotFoundException(String message) {
		super(message);
	}

}
