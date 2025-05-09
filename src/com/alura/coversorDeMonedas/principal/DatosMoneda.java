package com.alura.coversorDeMonedas.principal;

import java.util.Map;

public class DatosMoneda {
    public static final Map<String, Moneda> MONEDAS = Map.ofEntries(
            Map.entry("sol", new Moneda("sol", "PEN")),
            Map.entry("soles", new Moneda("sol", "PEN")),

            Map.entry("dolar", new Moneda("dólar", "USD")),
            Map.entry("dolares", new Moneda("dólar", "USD")),

            Map.entry("peso mexicano", new Moneda("peso mexicano", "MXN")),
            Map.entry("pesos mexicanos", new Moneda("peso mexicano", "MXN")),

            Map.entry("peso argentino", new Moneda("peso argentino", "ARS")),
            Map.entry("pesos argentinos", new Moneda("peso argentino", "ARS")),

            Map.entry("real", new Moneda("real", "BRL")),
            Map.entry("reales", new Moneda("real", "BRL")),

            Map.entry("euro", new Moneda("euro", "EUR")),
            Map.entry("euros", new Moneda("euro", "EUR")),

            Map.entry("peso chileno", new Moneda("peso chileno", "CLP")),
            Map.entry("pesos chilenos", new Moneda("peso chileno", "CLP")),

            Map.entry("peso colombiano", new Moneda("peso colombiano", "COP")),
            Map.entry("pesos colombianos", new Moneda("peso colombiano", "COP")),

            Map.entry("peso uruguayo", new Moneda("peso uruguayo", "UYU")),
            Map.entry("pesos uruguayos", new Moneda("peso uruguayo", "UYU")),

            Map.entry("guarani", new Moneda("guaraní", "PYG")),
            Map.entry("guaranies", new Moneda("guaraní", "PYG")),

            Map.entry("boliviano", new Moneda("boliviano", "BOB")),
            Map.entry("bolivianos", new Moneda("boliviano", "BOB")),

            Map.entry("cordoba", new Moneda("córdoba", "NIO")),
            Map.entry("cordobas", new Moneda("córdoba", "NIO"))
    );
    public static String obtenerCodigoIso(String nombre) {
        String clave = nombre.toLowerCase().trim();
        Moneda moneda = MONEDAS.get(clave);

        if (moneda == null) {
            System.out.println("Moneda no encontrada: " + nombre);
            return null;
        }

        return moneda.codigoIso();
    }
}
