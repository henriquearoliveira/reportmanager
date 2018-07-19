package br.com.reportmanager.report.exceptions;

public class CidadeIndefinidaException extends RuntimeException {
	private static final long serialVersionUID = -1089427659979940761L;

	public CidadeIndefinidaException() {
	}
	
	public CidadeIndefinidaException(String cidade) {
		super("A cidade " + cidade + " ainda não é suportada.");
	}

}
