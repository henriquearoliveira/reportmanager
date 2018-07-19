package br.com.reportmanager.report;

import br.com.reportmanager.report.manager.ReportCSV;
import br.com.reportmanager.report.manager.ReportPDF;

public enum TypeFormat implements ReportFormat {

	PDF {

		@Override
		public byte[] download(Report report) {
			return new ReportPDF().download(report);
		}
	},
	
	CSV {

		@Override
		public byte[] download(Report report) {
			return new ReportCSV().download(report);
		}
	};

}
