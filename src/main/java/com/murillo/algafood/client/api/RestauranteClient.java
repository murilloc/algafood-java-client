package com.murillo.algafood.client.api;

import com.murillo.algafood.client.model.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static String RESOURCE_PATH = "/restaurantess";
    private String url;
    private RestTemplate restTemplate;

    public List<RestauranteResumoModel> listar() {

        try {
            URI resourceUri = URI.create(url + RESOURCE_PATH);
            RestauranteResumoModel[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumoModel[].class);
            return Arrays.asList(restaurantes);

        } catch (RestClientResponseException e) {
           throw new ClientApiException(e.getMessage(),e);
        }
    }
}
