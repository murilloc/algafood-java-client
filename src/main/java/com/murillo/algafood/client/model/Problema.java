package com.murillo.algafood.client.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Problema {

    private String status;
    private OffsetDateTime timestamp;
    private String userMessage;
    private List<Object> objects = new ArrayList<>();
}
