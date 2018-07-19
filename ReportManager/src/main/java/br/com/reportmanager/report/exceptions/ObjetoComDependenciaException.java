package br.com.reportmanager.report.exceptions;

public class ObjetoComDependenciaException extends RuntimeException {
	private static final long serialVersionUID = 36143184074135532L;

	public ObjetoComDependenciaException() {
		super("Existem dependências relacionadas ao objeto");
	}

	public ObjetoComDependenciaException(String mensagem) {
		super(mensagem);
	}
}
