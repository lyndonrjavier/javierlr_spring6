package com.spring.iocdi.app.injectcollections.components;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.iocdi.app.ctxnesting.components.Song;

@Configuration
public class CollectionConfig {
	@Bean
    List<Song> list(){
        return List.of(
                new Song("Not the end"),
                new Song("Rise Up")
        );
    }

    @Bean
    Song song1(){
        return new Song("Here's to hoping");
    }

    @Bean
    Song song2(){
        return new Song("Wishing the best for you");
    }
}
