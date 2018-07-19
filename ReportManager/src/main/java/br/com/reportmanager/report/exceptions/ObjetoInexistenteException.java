package br.com.reportmanager.report.exceptions;

public class ObjetoInexistenteException extends RuntimeException {
	private static final long serialVersionUID = -7061116460869965956L;

	public ObjetoInexistenteException() {
		super("O objeto requisitado não existe");
	}

	public ObjetoInexistenteException(String mensagem) {
		super(mensagem);
	}
}
