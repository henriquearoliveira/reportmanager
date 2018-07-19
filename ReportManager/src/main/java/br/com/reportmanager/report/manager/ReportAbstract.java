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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportAbstract {

	protected final String folderReports = "src/main/resources/reports/";

	protected JasperPrint print = null;

	private List<String> listReports = null;

	private Report report;

	protected void downloadFilesFromFTP(Report report) {
		this.report = report;

		listReports = Arrays.asList(report.getFtp().getPathReports().getDescription());

		listReports.forEach(e -> {
			new FTPRetrieveFile().download(e, report.getFtp());
		});

	}

	protected void populateReport() {

		try (Connection connection = DriverManager.getConnection(report.getDatabase().getUrlConnection(),
				report.getDatabase().getUsername(), report.getDatabase().getPassword());) {

			try {
				print = JasperFillManager.fillReport(
						folderReports + Tools.getLocalPath(Tools.getLocalPath(listReports.get(0))), report.getParams(),
						connection);
			} catch (JRException e) {
				System.out.println("ERRO NO PREENCHIMENTO DO RELATÓRIO");
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println("ERRO NA CONEXÃO");
			e1.printStackTrace();
		}
	}

	protected byte[] serializePDF(String exportedReportname) {

		Path path = Paths.get(folderReports + exportedReportname);

		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("ERRO EM TRANSOFRMAR O ARQUIVO PARA BYTES");
			e.printStackTrace();
		}

		deleteFiles();

		return bytes;
	}

	private void deleteFiles() {
		try {
			Files.walk(Paths.get(folderReports)).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			System.out.println("DEU RUIM NA EXCLUSÃO.");
			e.printStackTrace();
		}
	}

}
