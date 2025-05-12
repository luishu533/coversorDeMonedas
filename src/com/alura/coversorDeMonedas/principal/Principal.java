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

                    assert resultado != null;

                    if (resultado.monedaOrigen().equals(resultado.monedaDestino())) {
                        System.out.println("Las monedas de origen y destino son iguales.");
                        continue;
                    }
                    if (resultado.cantidad() <= 0) {
                        System.out.println("La cantidad debe ser mayor a cero.");
                        continue;
                    }

                    DecimalFormat formato = new DecimalFormat("#.##");

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

                } catch (NumberFormatException e) {
                    System.out.println("Error: La cantidad ingresada no es un número válido.");
                } catch (NullPointerException e) {
                    System.out.println("Error: No se pudo obtener la tasa de cambio.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            }
        }
    }
}
