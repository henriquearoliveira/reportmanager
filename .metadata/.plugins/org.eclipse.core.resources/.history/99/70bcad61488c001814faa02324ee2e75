package br.com.reportmanager.report.service;

import org.springframework.stereotype.Service;

import br.com.reportmanager.report.Report;

@Service
public class ReportService {

	public byte[] buildReport(Report report) {
		return report.getTypeFormat().download(report);
	}

}
