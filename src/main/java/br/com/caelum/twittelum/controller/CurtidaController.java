package br.com.caelum.twittelum.controller;

import br.com.caelum.twittelum.dao.CurtidaDao;
import br.com.caelum.twittelum.modelo.Curtida;
import br.com.caelum.twittelum.modelo.Tweet;
import br.com.caelum.twittelum.modelo.Usuario;
import br.com.caelum.twittelum.modelo.dto.TweetComCurtidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.org.apache.regexp.internal.RE;

@RestController
@RequestMapping("/curtida")
public class CurtidaController {

    private CurtidaDao curtidaDao;

    @Autowired
    public CurtidaController(CurtidaDao curtidaDao) {
        this.curtidaDao = curtidaDao;
    }


    @PostMapping
    public ResponseEntity curte(@RequestBody TweetComCurtidor tweetComCurtidor) {

        Curtida curtida = new Curtida(tweetComCurtidor);

        Curtida curtidaSalva = curtidaDao.save(curtida);

        return ResponseEntity.ok(curtidaSalva);
    }

    @DeleteMapping
    public ResponseEntity descurte(@RequestBody TweetComCurtidor tweetComCurtidor) {

        Tweet tweet = tweetComCurtidor.getTweet();
        Usuario curtidor = tweetComCurtidor.getCurtidor();

        Curtida curtida = curtidaDao.findByCurtidorAndAndTweet(curtidor, tweet);

        curtidaDao.deleteById(curtida.getId());

        return ResponseEntity.ok().body("Tweet descurtido");

    }
}
