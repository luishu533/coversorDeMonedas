package com.alura.coversorDeMonedas.principal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FraseConversor {

    public record Resultado(double cantidad, String monedaOrigen, String monedaDestino) {

    }
    public static Resultado analizar(String entrada) {

        Pattern patron = Pattern.compile("(\\d+(\\.\\d+)?)\\s+(.+?)\\s+a\\s+(.+)");
        Matcher matcher = patron.matcher(entrada.toLowerCase());

        if (matcher.matches()) {
            double cantidad = Double.parseDouble(matcher.group(1));
            String monedaOrigen = matcher.group(3).toLowerCase().trim();
            String monedaDestino = matcher.group(4).toLowerCase().trim();
            return new Resultado(cantidad, monedaOrigen, monedaDestino);

        } else {
            System.out.println("Formato inválido. Usa el formato: <cantidad> <monedaOrigen> a <monedaDestino>");
        }

        return null;
    }
}
