package br.com.reportmanager.report.components;

public class Tools {
	
	public static String getLocalPath(String caminhoCompleto) {
		String caminho = caminhoCompleto.substring(caminhoCompleto.lastIndexOf("/") + 1, caminhoCompleto.length());
		return caminho;
	}

}
