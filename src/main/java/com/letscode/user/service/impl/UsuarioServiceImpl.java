package com.letscode.user.service.impl;


import com.letscode.user.dto.UsuarioRequest;
import com.letscode.user.dto.UsuarioResponse;
import com.letscode.user.exception.UsuarioException;
import com.letscode.user.model.Usuario;
import com.letscode.user.repository.UsuarioRepository;
import com.letscode.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse save(UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario(usuarioRequest);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioResponse(usuarioSalvo);
    }

    @Override
    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException());
        return new UsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return new UsuarioResponse(usuarioAtualizado);
    }

    @Override
    public void delete(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException());
        usuarioRepository.delete(usuario);
    }
}
