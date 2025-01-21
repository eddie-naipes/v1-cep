package com.nss.v1cep.domain;

import jakarta.validation.constraints.Pattern;
import lombok.Value;


@Value
public class Cep {
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP inválido.")
    String value;
}
