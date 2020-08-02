package com.murillo.algafood.client;

import com.murillo.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestauranteMain {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.algafood.local:8080";
        RestauranteClient restauranteClient = new RestauranteClient(url,restTemplate);
        restauranteClient.listar().forEach(System.out::println);
    }
}
