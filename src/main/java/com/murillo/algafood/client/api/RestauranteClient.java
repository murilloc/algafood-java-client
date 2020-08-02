package com.murillo.algafood.client.api;

import com.murillo.algafood.client.api.exception.ClientApiException;
import com.murillo.algafood.client.model.input.RestauranteInModel;
import com.murillo.algafood.client.model.output.RestauranteModel;
import com.murillo.algafood.client.model.output.RestauranteResumoModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static String RESOURCE_PATH = "/restaurantes";
    private String url;
    private RestTemplate restTemplate;

    public List<RestauranteResumoModel> listar() {

        try {
            URI resourceUri = URI.create(url + RESOURCE_PATH);
            RestauranteResumoModel[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumoModel[].class);
            return Arrays.asList(restaurantes);

        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }


    public RestauranteModel adicionar(RestauranteInModel restaurante) {
            var resourceUri = URI.create(url + RESOURCE_PATH);

        try {
            return restTemplate.postForObject(resourceUri, restaurante, RestauranteModel.class);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }

    }
}
