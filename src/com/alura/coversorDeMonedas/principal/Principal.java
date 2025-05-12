package com.alura.coversorDeMonedas.principal;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        ConsultaApi consultaApi = new ConsultaApi();

        try (Scanner scanner = new Scanner(System.in)) {
            Bienvenida.mostrarMensaje();
            while (true) {
                try {
                    System.out.println("\nIngresa la tasa de cambio que deseas consultar:");
                    String frase = scanner.nextLine();
                    if (frase.toLowerCase().trim().equals("salir")) {
                        System.out.println("Programa finalizado");
                        break;
                    }

                    FraseConversor.Resultado resultado = FraseConversor.analizar(frase);
                    DecimalFormat formato = new DecimalFormat("#.##");

                    assert resultado != null;

                    Conversor moneda = consultaApi.consultar(
                            DatosMoneda.obtenerCodigoIso(resultado.monedaOrigen()),
                            DatosMoneda.obtenerCodigoIso(resultado.monedaDestino()),
                            resultado.cantidad());

                    String fechaIngles = moneda.time_last_update_utc();
                    DateTimeFormatter formatoIngles = DateTimeFormatter.ofPattern(
                            "EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
                    ZonedDateTime fecha = ZonedDateTime.parse(fechaIngles, formatoIngles);
                    Locale localeEspanol = Locale.forLanguageTag("es-ES");
                    DateTimeFormatter formatoEspanol = DateTimeFormatter.ofPattern(
                            "EEEE, dd MMMM yyyy",
                            localeEspanol);

                    System.out.println(
                            resultado.cantidad() + " " +
                                    resultado.monedaOrigen() + " son: " +
                                    formato.format(moneda.conversion_result()) + " " +
                                    resultado.monedaDestino() + "\nÚltima actualización: " +
                                    fecha.format(formatoEspanol));

                } catch (Exception e) {
                    System.out.println("cantidad no valida");
                }
            }
        }
    }
}
