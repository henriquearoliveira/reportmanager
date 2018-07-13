package br.com.reportmanager.report.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.reportmanager.report.Report;
import br.com.reportmanager.report.components.PathReports;
import br.com.reportmanager.report.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportResource {

	@Autowired
	private ReportService service;

	@GetMapping
	public ResponseEntity<byte[]> testando() {

		// @RequestBody Report report

		Map<String, Object> param = new HashMap<>();
		param.put("id", new Long(13l));

		Report report = new Report();
		report.setParams(param);
		report.setPathReports(PathReports.FECHAMENTO_CAIXA);

		byte[] pdfReport = service.buildReport(report);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "pdf"));
		header.set("Content-Disposition", "inline; filename=report.pdf");
		header.setContentLength(pdfReport.length);

		return new ResponseEntity<byte[]>(pdfReport, header, HttpStatus.OK);

	}

}
