package com.letscode.user.service;

import com.letscode.user.dto.UsuarioRequest;
import com.letscode.user.dto.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse save(UsuarioRequest usuarioRequest);

    UsuarioResponse getById(Integer id);

    UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);

}
