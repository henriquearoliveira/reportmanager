package br.com.reportmanager.report.exceptions;

public class GeocodingException extends RuntimeException {
	private static final long serialVersionUID = 631760587382319677L;

	public GeocodingException(String status) {
		super(status);
	}
}
