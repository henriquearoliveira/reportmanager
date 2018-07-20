package br.com.reportmanager.report.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reportmanager.report.Database;
import br.com.reportmanager.report.FTP;
import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.TypeFormat;
import br.com.reportmanager.report.components.PathReports;
import br.com.reportmanager.report.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportResource {

	@Autowired
	private ReportService service;

	@PostMapping
	public ResponseEntity<byte[]> testando(@RequestBody Report report) {

		byte[] pdfReport = service.buildReport(report);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "pdf"));
		header.set("Content-Disposition", "inline; filename=report.pdf");
		header.setContentLength(pdfReport == null ? 0 : pdfReport.length);

		return new ResponseEntity<byte[]>(pdfReport, header, HttpStatus.OK);

	}

	@PostMapping("/teste")
	public ResponseEntity<Void> testeFTP(@RequestBody Report report) {

		System.out.println("TYPE: " + report.getTypeFormat());

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/report")
	public ResponseEntity<Report> testeReport() {

		Database dataBase = new Database();
		dataBase.setUrlConnection("jdbc:mysql://mysql472.umbler.com:41890/lavacar");
		dataBase.setUsername("lavacar");
		dataBase.setPassword("snowlifes");

		PathReports pathReports = PathReports.RELATORIO;
		pathReports.setDescription(new String[] { "FechamentoDeCaixa/FechamentoDeCaixa.jasper",
				"FechamentoDeCaixa/TabelaServicoVeiculo.jasper", "FechamentoDeCaixa/TabelaLancamento.jasper" });

		FTP ftp = new FTP();
		ftp.setPathReports(pathReports);
		ftp.setHostFTP("lavacardb-cloud.umbler.net");
		ftp.setUsername("lavacardb-cloud");
		ftp.setPort(21);
		ftp.setPassword(">R9*)CavrYg_a$[");

		Map<String, Object> params = new HashMap<>();
		params.put("idFluxoDeCaixa", 43l);

		Report report = new Report();
		report.setDatabase(dataBase);
		report.setFtp(ftp);
		report.setParams(params);
		report.setTypeFormat(TypeFormat.PDF);

		return ResponseEntity.ok(null);
	}

}
