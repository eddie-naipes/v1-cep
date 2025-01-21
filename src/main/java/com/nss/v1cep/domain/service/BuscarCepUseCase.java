package com.nss.v1cep.domain.service;

import com.nss.v1cep.api.dto.ConsultaCepResponse;
import com.nss.v1cep.domain.Cep;
import com.nss.v1cep.domain.ConsultaCep;
import com.nss.v1cep.infrastructure.persistence.ConsultaCepEntity;
import com.nss.v1cep.infrastructure.persistence.ConsultaCepRepository;
import com.nss.v1cep.domain.mapper.ConsultaCepMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarCepUseCase {

    private final ConsultaCepRepository consultaCepRepository;
    private final ApiExternaService apiExternaService;
    private final ConsultaCepMapper consultaCepMapper;

    public ConsultaCep buscar(String cep) {
        ConsultaCepResponse response = apiExternaService.buscarCep(cep);

        ConsultaCep consultaCep = consultaCepMapper.toDomain(response);

        ConsultaCepEntity entity = consultaCepMapper.toEntity(consultaCep);
        consultaCepRepository.save(entity);

        return consultaCep;
    }
}
