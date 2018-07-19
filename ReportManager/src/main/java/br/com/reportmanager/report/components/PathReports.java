package br.com.reportmanager.report.components;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PathReports {

	// "FechamentoDeCaixa/FechamentoDeCaixa.jasper","FechamentoDeCaixa/TabelaServicoVeiculo.jasper",
	// "FechamentoDeCaixa/TabelaLancamento.jasper"
	RELATORIO(new String[] { });

	// "FechamentoDeCaixa_Periodo/FechamentoDeCaixa.jasper", "FechamentoDeCaixa_Periodo/TabelaServicoVeiculo.jasper",
	// "FechamentoDeCaixa_Periodo/TabelaLancamento.jasper"
	/*FECHAMENTO_CAIXA_PERIODO(new String[] { "FechamentoDeCaixa_Periodo/FechamentoDeCaixa.jasper",
			"FechamentoDeCaixa_Periodo/TabelaServicoVeiculo.jasper",
			"FechamentoDeCaixa_Periodo/TabelaLancamento.jasper" });*/

	private String[] description;

	PathReports(String[] description) {
		this.description = description;
	}

	@JsonCreator
	public static PathReports getByDescription(String[] description) {

		PathReports path = PathReports.RELATORIO;
		path.setDescription(description);
		
		return path;
	}

	// DA PRA FAZER COM CASE
	public List<String> getRelatorios(PathReports relatorios) {

		if (relatorios == null)
			return null;

		List<String> rela = new LinkedList<>();

		for (PathReports caminho : PathReports.values()) {

			if (relatorios.equals(caminho)) {

				for (String descricao : relatorios.getDescription()) {

					rela.add(descricao);

				}

			}

		}

		return rela;

	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

}
