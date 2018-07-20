package br.com.reportmanager.report.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.reportmanager.report.manager.ReportAbstract;

@Component
public class DeleteFiles {
	
	@Scheduled(fixedDelay = 1800000)
	public void deleteFiles() {
		ReportAbstract.deleteFiles();
	}

}
