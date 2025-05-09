package com.alura.coversorDeMonedas.principal;

public class FraseConversor {

    public record Resultado(double cantidad, String monedaOrigen, String monedaDestino) {

    }
    public static Resultado analizar(String entrada) {
        String[] partes = entrada.toLowerCase().split(" ");

        if (partes.length == 4 && partes[2].equals("a")) {
            try {
                double cantidad = Double.parseDouble(partes[0]);
                String monedaOrigen = partes[1];
                String monedaDestino = partes[3];
                return new Resultado(cantidad, monedaOrigen, monedaDestino);
            } catch (NumberFormatException e) {
                System.out.println("cantidad no valida");
            }
        }else System.out.println("Formato incorrecto. Usa: [cantidad] [moneda1] a [moneda2]");

        return null;
    }
}
