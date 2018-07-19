package br.com.reportmanager.report.exceptions;

public class AcessoNaoAutorizadoException extends RuntimeException {
	private static final long serialVersionUID = -5823556046281005781L;

	public AcessoNaoAutorizadoException() {
		super("Acesso não autorizado");
	}
	
	public AcessoNaoAutorizadoException(String mensagem) {
		super(mensagem);
	}
}
