package br.com.caelum.twittelum.dao;

import br.com.caelum.twittelum.modelo.Usuario;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface UsuarioDao extends Repository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    Usuario save(Usuario usuario);

    Optional<Usuario> findByUsernameAndSenha(String username, String senha);

}
