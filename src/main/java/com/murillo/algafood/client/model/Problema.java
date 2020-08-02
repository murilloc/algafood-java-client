package com.murillo.algafood.client.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Problema {

    private String status;
    private OffsetDateTime timestamp;
    private String userMessage;
}
