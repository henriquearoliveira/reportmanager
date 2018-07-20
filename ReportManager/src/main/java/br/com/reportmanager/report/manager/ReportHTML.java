package br.com.reportmanager.report.manager;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.ReportFormat;
<<<<<<< HEAD
=======
import br.com.reportmanager.report.exceptions.OperacaoNaoPermitidaException;
>>>>>>> 222c6c60576640d3606b4fde29220a0cc7058af3
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

public class ReportHTML extends ReportAbstract implements ReportFormat {

<<<<<<< HEAD
	private final String exportedReportname = "relatorio.html";
=======
	private final String exportedReportname = "report.html";
>>>>>>> 222c6c60576640d3606b4fde29220a0cc7058af3

	@Override
	public byte[] download(Report report) {

		buildReport(report);

		genareteReport();

		return serialize(exportedReportname);
	}

	private void genareteReport() {

		try {
			JasperExportManager.exportReportToHtmlFile(print, folderReports + exportedReportname);
<<<<<<< HEAD
		} catch (JRException e1) {
			e1.printStackTrace();
=======
		} catch (JRException e) {
			throw new OperacaoNaoPermitidaException("Impossible to generate the report in HTML format");
>>>>>>> 222c6c60576640d3606b4fde29220a0cc7058af3
		}

	}

}
