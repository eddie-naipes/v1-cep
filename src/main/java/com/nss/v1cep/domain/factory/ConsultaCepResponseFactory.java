package com.nss.v1cep.domain.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nss.v1cep.api.dto.ConsultaCepResponse;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCepResponseFactory {

    private final ObjectMapper objectMapper;

    public ConsultaCepResponseFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ConsultaCepResponse create(String cep, String apiResponse) {
        try {
            ConsultaCepResponse.RetornoApi retornoApi = objectMapper.readValue(apiResponse, ConsultaCepResponse.RetornoApi.class);
            return ConsultaCepResponse.builder()
                    .cep(cep)
                    .dataConsulta(java.time.LocalDateTime.now().toString())
                    .retornoApi(retornoApi)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar a resposta da API externa", e);
        }
    }
}
