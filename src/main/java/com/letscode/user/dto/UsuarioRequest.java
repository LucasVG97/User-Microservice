package com.letscode.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsuarioRequest {

    @NotNull
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String senha;
}
