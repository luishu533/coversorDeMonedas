package com.alura.coversorDeMonedas.principal;

public class Bienvenida {
    public static void mostrarMensaje() {
        System.out.println("\n" +
                "_________                                                        _________          ______  ___                 _________              \n" +
                "__  ____/_______________   __________________________________    ______  /____      ___   |/  /_______________________  /_____ ________\n" +
                "_  /    _  __ \\_  __ \\_ | / /  _ \\_  ___/_  ___/  __ \\_  ___/    _  __  /_  _ \\     __  /|_/ /_  __ \\_  __ \\  _ \\  __  /_  __ `/_  ___/\n" +
                "/ /___  / /_/ /  / / /_ |/ //  __/  /   _(__  )/ /_/ /  /        / /_/ / /  __/     _  /  / / / /_/ /  / / /  __/ /_/ / / /_/ /_(__  ) \n" +
                "\\____/  \\____//_/ /_/_____/ \\___//_/    /____/ \\____//_/         \\__,_/  \\___/      /_/  /_/  \\____//_/ /_/\\___/\\__,_/  \\__,_/ /____/  \n" +
                "                                                                                                                                      ");
        System.out.println("By Luis Huanca (huanca.luis@gmail.com)");
        System.out.println("\n*************************************************");
        System.out.println("MODO DE USO: [cantidad] [moneda1] a [moneda2]");
        System.out.println("EJEMPLO: 1000 dolares a soles");
        System.out.println("'Para cerrar el programa escribe: salir'");
        System.out.println("*************************************************");
    }
}
