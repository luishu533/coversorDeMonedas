package com.alura.coversorDeMonedas.principal;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {

        ConsultaApi consultaApi = new ConsultaApi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                "   ______                                                  __   \n" +
                "  / ____/___  ____ _   _____  ______________  _____   ____/ /__ \n" +
                " / /   / __ \\/ __ \\ | / / _ \\/ ___/ ___/ __ \\/ ___/  / __  / _ \\\n" +
                "/ /___/ /_/ / / / / |/ /  __/ /  (__  ) /_/ / /     / /_/ /  __/\n" +
                "\\____/\\____/_/ /_/|___/\\___/_/  /____/\\____/_/      \\__,_/\\___/ \n" +
                "                                                                \n" +
                "    __  ___                     __          \n" +
                "   /  |/  /___  ____  ___  ____/ /___ ______\n" +
                "  / /|_/ / __ \\/ __ \\/ _ \\/ __  / __ `/ ___/\n" +
                " / /  / / /_/ / / / /  __/ /_/ / /_/ (__  ) \n" +
                "/_/  /_/\\____/_/ /_/\\___/\\__,_/\\__,_/____/  ");
        System.out.println("\n" +
                "+-+-+ +-+-+-+-+ +-+-+-+-+-+-+\n" +
                "|B|y| |L|u|i|s| |H|u|a|n|c|a|\n" +
                "+-+-+ +-+-+-+-+ +-+-+-+-+-+-+");
        System.out.println("\n*************************************************");
        System.out.println("modo de uso: [cantidad] [moneda1] a [moneda2]");
        System.out.println("ejemplo: 1000 dolares a soles");
        System.out.println("Para cerrar el programa escribe: salir");
        System.out.println("*************************************************");

        while (true) {
            try {
            System.out.println("\ningresa monto: ");
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
        scanner.close();
    }
}
