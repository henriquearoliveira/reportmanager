package br.com.reportmanager.report.exceptions;

public class ObjetoExistenteException extends RuntimeException{
	private static final long serialVersionUID = 6089129662728490193L;

	public ObjetoExistenteException() {
		super("Há um cadastro anterior impedindo a operação.");
	}
	
	public ObjetoExistenteException(String mensagem) {
		super(mensagem);
	}
}
