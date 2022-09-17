package br.com.poo.projetofinal.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataUtil {

	public static String converterDateParaDataEHora(Date data) {

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
		// 08/08/2021 12:52 hrs
		return formatador.format(data);

	}

	public static String converterDateParaData(Date data) {

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY");
		// 08/08/2021 12:52 hrs
		return formatador.format(data);

	}

	public static String converterDateParaHora(Date data) {

		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		// 08/08/2021 12:52 hrs
		return formatador.format(data);

	}
	
	public static String data() {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy 'as' hh:mm:ss a");
        String dataFormatada = data.format(formatada);
        return dataFormatada;
    }

}