package com.nss.v1cep.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaCepResponse {
    private String cep;
    private String dataConsulta;
    private RetornoApi retornoApi;

    @Data
    @Builder
    public static class RetornoApi {
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
        private String ibge;
        private String gia;
        private String ddd;
        private String siafi;
    }
}
