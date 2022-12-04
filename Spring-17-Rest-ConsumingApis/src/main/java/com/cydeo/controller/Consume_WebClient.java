package com.cydeo.controller;

import com.cydeo.dto.GenreDTO;
import com.cydeo.dto.MovieCinemaDTO;
import com.cydeo.service.GenreService;
import com.cydeo.service.MovieCinemaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {
    /*
    Reactive Programming ->  there are two terms
             1.Synchronised -> (start and finishing one by one) you are sending one request to Api or someone sends some
             request and you API is doing all the necessary things, and is waiting for second request.
             2.Asynchronous -> APi is taking all the request and, it does wait for some request to be finished in the background,
             and is sending what ever you need to DB for example
             ,and if DB is creating in reactive way it creates many Objects in tha same time.
*/


    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build(); // this is an Object

    private final MovieCinemaService movieCinemaService;
    private final GenreService genreService;

    public Consume_WebClient(MovieCinemaService movieCinemaService, GenreService genreService) {
        this.movieCinemaService = movieCinemaService;
        this.genreService = genreService;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinemaDTO> readAllCinemaFlux(){
        // Flux means multiple elements like List (many)!
        return Flux.fromIterable(movieCinemaService.findAll());

    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinemaDTO> readById(@PathVariable("id") Long id){
//
//        return Mono.just(movieCinemaService.findById(id));
//
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinemaDTO>> readById(@PathVariable("id") Long id){

        return ResponseEntity.ok(Mono.just(movieCinemaService.findById(id)));

    }

    @PostMapping("/create-genre")
    public Mono<GenreDTO> createGenre(@RequestBody GenreDTO genre){
        // Mono class-> if we want that API to return one Object

        GenreDTO createdGenre = genreService.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){

        genreService.deleteById(id);

        return Mono.empty();
    }

//    ---------------------------WEBCLIENT---------------------------

    @GetMapping("/flux")
    public Flux<MovieCinemaDTO> readWithWebClient(){
          // consuming reactive API
        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinemaDTO.class); // multiple cinema Objects

    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinemaDTO> readMonoWithWebClient(@PathVariable("id") Long id){

        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinemaDTO.class); // return one Object

    }

}
