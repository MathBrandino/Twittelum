package br.com.caelum.twittelum.modelo.dto;

import br.com.caelum.twittelum.modelo.Tweet;
import br.com.caelum.twittelum.modelo.Usuario;

public class TweetComCurtidor {

    private Tweet tweet;
    private Usuario curtidor;

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public Usuario getCurtidor() {
        return curtidor;
    }

    public void setCurtidor(Usuario curtidor) {
        this.curtidor = curtidor;
    }
}
