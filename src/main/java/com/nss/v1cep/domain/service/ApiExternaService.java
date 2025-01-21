package com.nss.v1cep.domain.service;

import com.nss.v1cep.api.dto.ConsultaCepResponse;

public interface ApiExternaService {
    ConsultaCepResponse buscarCep(String cep);
}
