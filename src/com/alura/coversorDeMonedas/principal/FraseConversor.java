package com.alura.coversorDeMonedas.principal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FraseConversor {

    public record Resultado(double cantidad, String monedaOrigen, String monedaDestino) {

    }
    public static Resultado analizar(String entrada) {

        Pattern patron = Pattern.compile(
                ".*?" + // captura cualquier cosa al inicio
                        "(\\d+" + // captura cantida numerica
                        "(\\.\\d+)?)" + // captura decimales opcionales
                        "\\s+" + // captura espacios en blanco
                        "([a-záéíóú]+" + // captura la moneda de origen
                        "(?:\\s[a-záéíóú]+)*)" + // captura la segunda parte de la moneda (opcional)
                        "\\s+" + // captura espacios en blanco
                        "(a|en)" + // captura la palabra "a" o "en"
                        "\\s+" + // captura espacios en blanco
                        "([a-záéíóú]+(?:\\s[a-záéíóú]+)*).*", // captura la moneda de destino
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = patron.matcher(entrada.toLowerCase());

        if (matcher.matches()) {
            double cantidad = Double.parseDouble(matcher.group(1));
            String monedaOrigen = matcher.group(3).toLowerCase().trim();
            String monedaDestino = matcher.group(5).toLowerCase().trim();
            return new Resultado(cantidad, monedaOrigen, monedaDestino);

        } else {
            System.out.println("Formato inválido. Usa el formato: <cantidad> <monedaOrigen> a <monedaDestino>");
        }

        return null;
    }
}
