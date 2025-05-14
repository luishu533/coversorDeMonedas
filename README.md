# Conversor de Monedas

Este proyecto en Java fue elaborado gracias al desafio propuesto por la institucion Alura Latam como prueba final del 
curso "Java Orientado a Objetos G8 - ONE" que permite convertir montos entre diferentes monedas utilizando una API de 
tipo Exchange Rate. El programa toma una entrada en formato de texto, analiza la cantidad y las monedas de origen y 
destino, y realiza la conversión mostrando el resultado.

## Características

- Conversión de monedas entre diferentes divisas.
- Soporte para múltiples monedas como dólar, euro, peso mexicano, peso argentino, entre otros.
- Uso de una API para obtener tasas de cambio actualizadas.
- Formato de fecha en español para mostrar la última actualización.

## Requisitos

- **Java 17 o superior**.
- **Biblioteca Gson**: Incluida en el proyecto en el archivo `src/lib/gson-2.13.1.jar`.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/luishu533/coversorDeMonedas.git
2. Abre el proyecto en un IDE de Java (por ejemplo, Eclipse o IntelliJ IDEA).
3. Asegúrate de que la biblioteca Gson esté configurada como dependencia.

## Uso
1. Ejecuta el programa desde el IDE o desde la consola con el comando `java
2. sigue las siguentes instruciones en la consola:  
    ° Ingrese el monto y las monedas en el formato.  
     `<cantidad> <monedaOrigen> a <monedaDestino>`  
    ° Por ejemplo: 1000 dólares a soles.  
    ° Escribe "salir" para finalizar el programa.
   
![gifDelProyecto](https://github.com/user-attachments/assets/cd3bf2ee-1470-492c-aab5-4e2676fc37de)

## Ejemplo de Salida
    *************************************************
    Modo de uso: [cantidad] [moneda1] a [moneda2]
    ejemplo: 1000 dólares a soles
    Para cerrar el programa escribe: salir
    *************************************************

    ingresa monto: 
    1000 dolares a soles
    1000.0 dolares son: 3800.0 soles
    Última actualización: lunes, 7 mayo 2025  

## Estructura del Proyecto
    src/
    └── com/
        └── alura/
            └── coversorDeMonedas/
                └── principal/
                    ├── [Bienvenida.java]
                    ├── [ConsultaApi.java]
                    ├── [Conversor.java]
                    ├── [DatosMoneda.java]
                    ├── [FraseConversor.java]
                    ├── [Moneda.java]
                    └── [Principal.java]

° **Principal.java:** Clase principal que ejecuta el programa.  
° **ConsultaApi.java:** Realiza consultas a la API de tasas de cambio.  
° **DatosMoneda.java:** Contiene un mapa de monedas soportadas.  
° **FraseConversor.java:** Analiza la entrada del usuario.  
° **Moneda.java:** Representa una moneda con su nombre y código ISO.  
° **Conversor.java:** Modelo para los datos de conversión obtenidos de la API.   
° **Bienvenida.java:** Contiene mensajes de bienvenida y ejemplos del modo de uso.

## API Utilizada
El proyecto utiliza la API de ExchangeRate-API para obtener las tasas de cambio. Asegúrate de reemplazar la clave 
de API en [ConsultaApi](https://www.exchangerate-api.com/) con tu propia clave si es necesario.

## Contribuciones
Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request.


