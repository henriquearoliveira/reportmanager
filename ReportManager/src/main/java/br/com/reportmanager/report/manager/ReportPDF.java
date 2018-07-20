package br.com.reportmanager.report.manager;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.ReportFormat;
import br.com.reportmanager.report.exceptions.OperacaoNaoPermitidaException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

public class ReportPDF extends ReportAbstract implements ReportFormat {

	private final String exportedReportname = "report.pdf";

	@Override
	public byte[] download(Report report) {

		buildReport(report);

		genareteReport();

		return serialize(exportedReportname);
	}

	private void genareteReport() {

		try {
			JasperExportManager.exportReportToPdfFile(print, folderReports + exportedReportname);
		} catch (JRException e) {
			throw new OperacaoNaoPermitidaException("Impossible to generate the report in PDF format");
		}

	}

}
