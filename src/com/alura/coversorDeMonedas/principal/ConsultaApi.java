package com.alura.coversorDeMonedas.principal;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Conversor consultar(String codigoOrigen, String codigoDestino, double cantidad){
        URI direccion = URI.create
                ("https://v6.exchangerate-api.com/v6/aead8d6ed407c374acbff196/pair/"+
                        codigoOrigen+
                        "/"+codigoDestino+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("error al consultar api");
        }

    }

}
