package com.murillo.algafood.client.api.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.murillo.algafood.client.model.Problema;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientResponseException;

@Slf4j
public class ClientApiException extends RuntimeException {


    private static final long serialVersionUID = 838554247246211600L;

    @Getter
    private Problema problem;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        desserializeProblem(cause);
    }

    private void desserializeProblem(RestClientResponseException cause) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();
        try {
            this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problema.class);
        } catch (JsonProcessingException e) {
            log.warn("Não foi possível desserializar a resposta de um problema");
        }
    }
}
