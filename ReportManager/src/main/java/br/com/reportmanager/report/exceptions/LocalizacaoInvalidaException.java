package br.com.reportmanager.report.exceptions;

public class LocalizacaoInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 6073973509427362200L;

	public LocalizacaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}
