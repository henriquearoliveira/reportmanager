package br.com.reportmanager.report.components.ftp;

import br.com.reportmanager.report.FTP;

public class FTPRetrieveFile extends FTPAbstract {

    @Override
    public boolean download(String file, FTP ftp) {
        return downloadArquivo(file, ftp);
    }

    @Override
    public boolean upload() {
        return false;
    }
}
