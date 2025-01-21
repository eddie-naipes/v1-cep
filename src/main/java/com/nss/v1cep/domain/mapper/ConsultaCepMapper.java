package com.nss.v1cep.domain.mapper;

import com.nss.v1cep.api.dto.ConsultaCepResponse;
import com.nss.v1cep.domain.Cep;
import com.nss.v1cep.domain.ConsultaCep;
import com.nss.v1cep.infrastructure.persistence.ConsultaCepEntity;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCepMapper {

    public ConsultaCep toDomain(ConsultaCepResponse response) {
        return new ConsultaCep(
                new Cep(response.getCep()),
                java.time.LocalDateTime.now(),
                response.getRetornoApi().toString()
        );
    }

    public ConsultaCepEntity toEntity(ConsultaCep consultaCep) {
        return new ConsultaCepEntity(
                null,
                consultaCep.getCep().getValue(),
                consultaCep.getDataConsulta(),
                consultaCep.getRetornoApi()
        );
    }
}
