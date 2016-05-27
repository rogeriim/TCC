package br.com.tccmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	private static SimpleDateFormat stringFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	public static Date StringToDate(String data) {
		Date parsedDate = null;

		try {
			parsedDate = dateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return parsedDate;
	}

	public static String DateToString(Date data) {
		return stringFormat.format(data);
	}

}
