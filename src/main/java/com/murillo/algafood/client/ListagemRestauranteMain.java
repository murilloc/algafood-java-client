package com.murillo.algafood.client;

import com.murillo.algafood.client.api.exception.ClientApiException;
import com.murillo.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestauranteMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://api.algafood.local:8080";

            RestauranteClient restauranteClient = new RestauranteClient(url, restTemplate);
            restauranteClient.listar().forEach(System.out::println);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }

    }
}
