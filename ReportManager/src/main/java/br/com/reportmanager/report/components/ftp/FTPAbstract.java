package br.com.reportmanager.report.components.ftp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;

import br.com.reportmanager.report.FTP;
import br.com.reportmanager.report.components.Tools;

public abstract class FTPAbstract implements FTPConnection {

	public static String getPathDownloads() {
		return "src/main/resources/reports/";
	}

	@SuppressWarnings("finally")
	protected boolean downloadArquivo(String file, FTP ftp) {

		FTPClient ftpClient = new FTPClient();

		boolean success = false;

		try {

			ftpClient.connect(ftp.getHostFTP(), ftp.getPort());
			ftpClient.login(ftp.getUsername(), ftp.getPassword());
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);

			String caminhoLocal = Tools.getLocalPath(file);

			File diretorioLocal = new File(getPathDownloads());

			if (!diretorioLocal.exists())
				diretorioLocal.mkdirs();

			File downloadFile = new File(getPathDownloads() + caminhoLocal);

			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile));
			success = ftpClient.retrieveFile(file, outputStream1);
			outputStream1.close();

			if (success) {
				downloadFile.deleteOnExit();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
			return success;

		} finally {

			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return success;
		}

	}

}
