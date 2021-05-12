package br.com.fiap.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

	//Retorna a data formatada
	public static String formatar(Calendar data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());
	}
	
}
