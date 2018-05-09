package br.com.caelum.twittelum.controller;

import br.com.caelum.twittelum.dao.TweetDao;
import br.com.caelum.twittelum.modelo.Tweet;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    private TweetDao tweetDao;

    @Autowired
    public TweetController(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @GetMapping
    public List<Tweet> getTweets() {
        return tweetDao.findAll();
    }


    @GetMapping(value = "/{id}/")
    public ResponseEntity getTweet(@PathVariable("id") Long id) {

        Optional<Tweet> tweet = tweetDao.findById(id);

        if (tweet.isPresent()) {
            return ResponseEntity.ok(tweet.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há tweet para esse id");
    }


    @PostMapping
    public ResponseEntity salva(@RequestBody Tweet tweet){

        Tweet tweetSalvo = tweetDao.save(tweet);

        return getTweet(tweetSalvo.getId());

    }

}
