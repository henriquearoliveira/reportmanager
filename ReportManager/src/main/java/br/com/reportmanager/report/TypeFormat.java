package br.com.reportmanager.report;

import br.com.reportmanager.report.manager.ReportHTML;
import br.com.reportmanager.report.manager.ReportPDF;

public enum TypeFormat implements ReportFormat {

	PDF {

		@Override
		public byte[] download(Report report) {
			return new ReportPDF().download(report);
		}
	},
	
	HTML {

		@Override
		public byte[] download(Report report) {
			return new ReportHTML().download(report);
		}
	};

}
