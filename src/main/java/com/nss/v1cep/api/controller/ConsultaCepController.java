package com.nss.v1cep.api.controller;

import com.nss.v1cep.api.dto.ConsultaCepResponse;
import com.nss.v1cep.domain.service.ApiExternaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsultaCepController {

    private final ApiExternaService apiExternaService;

    @GetMapping("/api/cep/{cep}")
    public ConsultaCepResponse buscarCep(@PathVariable String cep) {
        return apiExternaService.buscarCep(cep);
    }
}
