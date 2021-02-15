package br.com.jonataslaet.mvc.mudi.util;

import java.time.format.DateTimeFormatter;

public class Data {

	public static DateTimeFormatter formatter (String formato) {
		return DateTimeFormatter.ofPattern(formato);
	}
}
