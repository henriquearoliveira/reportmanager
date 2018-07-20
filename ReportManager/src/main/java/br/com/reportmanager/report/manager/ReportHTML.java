package br.com.reportmanager.report.manager;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.ReportFormat;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

public class ReportHTML extends ReportAbstract implements ReportFormat {

	private final String exportedReportname = "relatorio.html";

	@Override
	public byte[] download(Report report) {

		buildReport(report);

		genareteReport();

		return serialize(exportedReportname);
	}

	private void genareteReport() {

		try {
			JasperExportManager.exportReportToHtmlFile(print, folderReports + exportedReportname);
		} catch (JRException e1) {
			e1.printStackTrace();
		}

	}

}
