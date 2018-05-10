package br.com.caelum.twittelum.dao;

import br.com.caelum.twittelum.modelo.Tweet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface TweetDao extends Repository<Tweet, Long> {


    List<Tweet> findAll();

    Optional<Tweet> findById(Long id);

    Tweet save(Tweet tweet);

    void deleteById(Long id);

    void deleteAll();
}
