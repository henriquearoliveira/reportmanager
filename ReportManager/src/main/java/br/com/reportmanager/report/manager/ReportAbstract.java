package br.com.reportmanager.report.manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.components.Tools;
import br.com.reportmanager.report.components.ftp.FTPRetrieveFile;
import br.com.reportmanager.report.exceptions.OperacaoNaoPermitidaException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportAbstract {

	protected static final String folderReports = "src/main/resources/reports/";

	protected JasperPrint print = null;

	private List<String> listReports = null;

	private Report report;

	protected void buildReport(Report report) {

		downloadFilesFromFTP(report);

		populateReport();

	}

<<<<<<< HEAD
	protected void downloadFilesFromFTP(Report report) {
=======
	private void downloadFilesFromFTP(Report report) {
>>>>>>> 222c6c60576640d3606b4fde29220a0cc7058af3
		this.report = report;

		listReports = Arrays.asList(report.getFtp().getPathReports().getDescription());

		listReports.forEach(e -> {
			new FTPRetrieveFile().download(e, report.getFtp());
		});

	}

	private void populateReport() {

		try (Connection connection = DriverManager.getConnection(report.getDatabase().getUrlConnection(),
				report.getDatabase().getUsername(), report.getDatabase().getPassword());) {

			try {
				print = JasperFillManager.fillReport(
						folderReports + Tools.getLocalPath(Tools.getLocalPath(listReports.get(0))), report.getParams(),
						connection);
			} catch (JRException e) {
				throw new OperacaoNaoPermitidaException("Did not possible to populate the report.");
			}

		} catch (SQLException e1) {
			throw new OperacaoNaoPermitidaException("Connection error with database, please confirm the credentials.");
		}
	}

	protected byte[] serialize(String exportedReportname) {

		Path path = Paths.get(folderReports + exportedReportname);

		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			throw new OperacaoNaoPermitidaException(
					"File does not exists, please confirm the parameters names and values.");
		}

		deleteFiles();

		return bytes;
	}

	public static void deleteFiles() {

		File file = new File(folderReports);

		if (!file.exists())
			return;

		try {
			Files.walk(Paths.get(folderReports)).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			e.printStackTrace();
			throw new OperacaoNaoPermitidaException(
					"Something goes wrong with the files' deleting, in some time the collector will erase the folder.");
		}

	}

}
