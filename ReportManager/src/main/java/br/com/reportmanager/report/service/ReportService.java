package br.com.reportmanager.report.service;

import org.springframework.stereotype.Service;

import br.com.reportmanager.report.Report;

@Service
public class ReportService {
	
	public byte[] buildReport(Report report) {
		return report.getTypeFormat().download(report);
	}

	/*private final String folderReports = "src/main/resources/reports/";

	private JasperPrint print = null;

	public byte[] buildReport(Report report) {

		List<String> listReports = Arrays.asList(report.getFtp().getPathReports().getDescription());

		listReports.forEach(e -> {
			new FTPRetrieveFile().download(e, report.getFtp());
		});

		populateReport(report, listReports);

		byte[] bytes = serializePDF();

		deleteFiles();

		return bytes;

	}

	private byte[] serializePDF() {

		Path path = Paths.get(folderReports + "relatorio.pdf");

		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			System.out.println("ERRO EM TRANSOFRMAR O ARQUIVO PARA BYTES");
			e.printStackTrace();
		}

		return bytes;
	}

	private void populateReport(Report report, List<String> listReport) {

		try (Connection connection = DriverManager.getConnection(report.getDatabase().getUrlConnection(),
				report.getDatabase().getUsername(), report.getDatabase().getPassword());) {

			try {
				print = JasperFillManager.fillReport(folderReports + Tools.getLocalPath(Tools.getLocalPath(listReport.get(0))),
						report.getParams(), connection);
			} catch (JRException e) {
				System.out.println("ERRO NO PREENCHIMENTO DO RELATÓRIO");
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println("ERRO NA CONEXÃO");
			e1.printStackTrace();
		}

		if (print == null || print.getPages().isEmpty())
			System.out.println("VAZIOOOO");

		try {
			JasperExportManager.exportReportToPdfFile(print, folderReports + "relatorio.pdf");
		} catch (JRException e1) {
			e1.printStackTrace();
		}

	}

	private void deleteFiles() {
		try {
			Files.walk(Paths.get(folderReports)).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			System.out.println("DEU RUIM NA EXCLUSÃO.");
			e.printStackTrace();
		}
	}*/

}
