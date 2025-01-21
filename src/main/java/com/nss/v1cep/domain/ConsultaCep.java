package com.nss.v1cep.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ConsultaCep {
    private final Cep cep;
    private final LocalDateTime dataConsulta;
    private final String retornoApi;
}
