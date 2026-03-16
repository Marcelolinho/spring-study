package com.passtime.study.integration.etl.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViaCepBo {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String localidade;
    private String estado;
    private String ddd;
}
