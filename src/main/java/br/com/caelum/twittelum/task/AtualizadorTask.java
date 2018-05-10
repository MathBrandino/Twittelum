package br.com.caelum.twittelum.task;

import br.com.caelum.twittelum.dao.TweetDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AtualizadorTask {

    private static final int DEZ_MINUTOS = 1000 * 60 * 10;
    private static final String TODO_DIA_1_A_MEIA_NOITE = "0 0 0 1 * *";

    private TweetDao tweetDao;

    @Autowired
    public AtualizadorTask(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

    @Scheduled(fixedRate = DEZ_MINUTOS)
    public void ressucitaServidor() {

        // todo colocar uma requisição para a página
        // pensando que isso vai ficar no heroku
    }


    @Scheduled(cron = TODO_DIA_1_A_MEIA_NOITE)
    public void limpaDados() {

        tweetDao.deleteAll();

    }
}
