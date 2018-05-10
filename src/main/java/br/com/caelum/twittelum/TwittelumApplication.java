package br.com.caelum.twittelum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TwittelumApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwittelumApplication.class, args);
    }
}
