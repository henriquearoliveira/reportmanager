package br.com.reportmanager.report.exceptions;

public class TipoDesconhecidoException extends RuntimeException {
	private static final long serialVersionUID = -8154886783563360774L;

	public TipoDesconhecidoException() {
		super("Tipo (enum) desconhecido!");
	}

	public TipoDesconhecidoException(String mensagem) {
		super(mensagem);
	}
}
