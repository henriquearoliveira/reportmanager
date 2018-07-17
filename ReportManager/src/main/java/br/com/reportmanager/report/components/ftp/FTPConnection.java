package br.com.reportmanager.report.components.ftp;

import br.com.reportmanager.report.FTP;

public interface FTPConnection {

    boolean download(String file, FTP ftp);

    boolean  upload();

}
