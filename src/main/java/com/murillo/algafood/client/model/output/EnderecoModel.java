package com.murillo.algafood.client.model.output;

import lombok.Data;

@Data
public class EnderecoModel {


    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private CidadeModel cidade;
}
