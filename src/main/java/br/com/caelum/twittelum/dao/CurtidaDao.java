package br.com.caelum.twittelum.dao;

import br.com.caelum.twittelum.modelo.Curtida;
import br.com.caelum.twittelum.modelo.Tweet;
import br.com.caelum.twittelum.modelo.Usuario;

import org.springframework.data.repository.Repository;

public interface CurtidaDao extends Repository<Curtida, Long> {


    Curtida save(Curtida curtida);

    Curtida findByCurtidorAndAndTweet(Usuario curtidor, Tweet tweet);

    void deleteById(Long id);



}
