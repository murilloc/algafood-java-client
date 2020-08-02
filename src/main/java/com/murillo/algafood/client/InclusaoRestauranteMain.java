package com.murillo.algafood.client;

import com.murillo.algafood.client.api.RestauranteClient;
import com.murillo.algafood.client.api.exception.ClientApiException;
import com.murillo.algafood.client.model.input.CidadeIdInputModel;
import com.murillo.algafood.client.model.input.CozinhaIdInModel;
import com.murillo.algafood.client.model.input.EnderecoInModel;
import com.murillo.algafood.client.model.input.RestauranteInModel;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {

    public static void main(String[] args) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://api.algafood.local:8080";


            RestauranteInModel restaurante = new RestauranteInModel();
            restaurante.setNome("Velho Sonho");
            restaurante.setTaxaFrete(new BigDecimal("13.60"));

            CozinhaIdInModel cozinha = new CozinhaIdInModel();
            cozinha.setId(2L);
            restaurante.setCozinha(cozinha);

            EnderecoInModel endereco = new EnderecoInModel();
            endereco.setCep("22400-999");
            endereco.setLogradouro("Avenida Marechal Floriano");
            endereco.setNumero("160");
            endereco.setBairro("Centro");
            CidadeIdInputModel cidade = new CidadeIdInputModel();
            cidade.setId(1L);
            endereco.setCidade(cidade);
            restaurante.setEndereco(endereco);

            RestauranteClient restauranteClient = new RestauranteClient(url, restTemplate);
            System.out.println(restauranteClient.adicionar(restaurante).toString());

        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }


    }


}
