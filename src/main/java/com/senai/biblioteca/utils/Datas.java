package com.senai.biblioteca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Datas {
    public static Date stringToDate(String dataString) throws Exception {
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        SimpleDateFormat formatoPadraoData = new SimpleDateFormat("dd/MM/yyyy");
        if (!Pattern.matches(regex, dataString)) {
            throw new Exception("Formato de data inválido. Data deve estar no formato: DD/MM/AAAA.");
        }
        formatoPadraoData.setLenient(false);
        Date dataFormatada = formatoPadraoData.parse(dataString);
        return dataFormatada;
    }

    public static String dateToString(Date data) throws Exception {
        SimpleDateFormat formatoPadraoData = new SimpleDateFormat("dd/MM/yyyy");
        if (data == null) {
            throw new Exception("A data fornecido é nula.");
        }
        String dataString = formatoPadraoData.format(data);
        if (dataString.isEmpty()) {
            throw new Exception("Não foi possível converter a data em uma string.");
        }
        return dataString;
    }

    public static Integer anoAtual() {
        Calendar calendario = Calendar.getInstance();
        return calendario.get(Calendar.YEAR);
    }
}
