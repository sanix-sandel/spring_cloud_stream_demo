package com.sanix.spring_cloud_stream_demo.configuration;

import com.sanix.spring_cloud_stream_demo.movie.Movie;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Log4j2
@Configuration
public class MovieStream {

    @Bean
    public Supplier<Flux<Movie>>movie(){
        return ()->Flux.just(
                new Movie("The Matrix","Keanu Reaves", 1999, "science-fiction"),
                new Movie("It","Bill Skarsgard", 2017, "horror")
                );
    }
}
