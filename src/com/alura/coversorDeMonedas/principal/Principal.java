package com.alura.coversorDeMonedas.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        ConsultaApi consultaApi = new ConsultaApi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*************************************************");
        System.out.println("modo de uso: [cantidad] [moneda1] a [moneda2]");
        System.out.println("ejemplo: 1000 dolares a soles");
        System.out.println("ingresa monto: ");


        try {
            String frase = scanner.nextLine();
            FraseConversor.Resultado resultado = FraseConversor.analizar(frase);

            assert resultado != null;


            Conversor moneda = consultaApi.consultar(
                    DatosMoneda.obtenerCodigoIso(resultado.monedaOrigen()),
                    DatosMoneda.obtenerCodigoIso(resultado.monedaDestino()),
                    resultado.cantidad());
            System.out.println(moneda);

        } catch (Exception e) {
            System.out.println("cantidad no valida");
        }
    }
}
