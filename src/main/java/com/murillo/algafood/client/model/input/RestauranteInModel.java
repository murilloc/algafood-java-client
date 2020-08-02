package com.murillo.algafood.client.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class RestauranteInModel {

    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal taxaFrete;
    private CozinhaIdInModel cozinha;
    private EnderecoInModel endereco;


}
