package com.nss.v1cep.infrastructure.external;

import com.nss.v1cep.api.dto.ConsultaCepResponse;
import com.nss.v1cep.domain.factory.ConsultaCepResponseFactory;
import com.nss.v1cep.domain.service.ApiExternaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApiExternaServiceImpl implements ApiExternaService {

    private final RestTemplate restTemplate;
    private final ConsultaCepResponseFactory responseFactory;

    @Value("${api.external.base-url}")
    private String baseUrl;

    @Override
    public ConsultaCepResponse buscarCep(String cep) {
        String url = String.format("%s/cep/%s", baseUrl, cep);
        String apiResponse = restTemplate.getForObject(url, String.class);

        return responseFactory.create(cep, apiResponse);
    }
}
