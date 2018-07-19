package br.com.reportmanager.report.exceptions;

public class OperacaoNaoPermitidaException extends RuntimeException {
	private static final long serialVersionUID = 8344094754793999267L;

	public OperacaoNaoPermitidaException() {
		super("Operação não permitida");
	}
	
	public OperacaoNaoPermitidaException(String mensagem) {
		super(mensagem);
	}
}
