package tn.esprit.spring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tn.esprit.spring.Security.ActiveUserStore;

@Configuration
public class AppConfig {
    // beans

    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }

}