package br.com.caelum.twittelum.controller;

import br.com.caelum.twittelum.dao.UsuarioDao;
import br.com.caelum.twittelum.modelo.Usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private UsuarioDao usuarioDao;

    @Autowired
    public UsuarioController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @PostMapping
    public ResponseEntity cria(@RequestBody Usuario usuario) {


        Optional<Usuario> usuarioExistente = usuarioDao.findByUsername(usuario.getUsername());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já criado");
        }

        Usuario usuarioSalvo = usuarioDao.save(usuario);


        return ResponseEntity.ok(usuarioSalvo);

    }


    @PostMapping("/login")
    public ResponseEntity autorizaLoginDo(@RequestBody Usuario usuario) {

        Optional<Usuario> usuarioExistente = usuarioDao.findByUsernameAndSenha(usuario.getUsername(), usuario.getSenha());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioExistente.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario não encontrado na base");

    }

}
