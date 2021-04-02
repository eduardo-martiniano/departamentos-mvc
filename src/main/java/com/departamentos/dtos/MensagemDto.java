package com.departamentos.dtos;

import lombok.Data;

@Data
public class MensagemDto {
    private String mensagem;
    private Boolean sucesso;

    public MensagemDto(Boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }
}
