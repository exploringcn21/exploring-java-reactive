package com.exploringcn.project.movies.service;

import com.exploringcn.project.movies.domain.Movie;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MovieReactiveServiceTest {

    private MovieInfoService movieInfoService = new MovieInfoService();
    private ReviewService reviewService = new ReviewService();
    private MovieReactiveService movieReactiveService = new MovieReactiveService(movieInfoService, reviewService);

    @Test
    void getAllMovies() {
        // given
        // when
        var moviesFlux = movieReactiveService.getAllMovies();

        // then
        StepVerifier.create(moviesFlux)
                .assertNext(movie -> {
                    // assert name of the movie
                    assertEquals("Batman Begins", movie.getMovie().getName());

                    // assert on the no. of reviews for the movie
                    assertEquals(2, movie.getReviewList().size());
                })
                .assertNext(movie -> {
                    // assert name of the movie
                    assertEquals("The Dark Knight", movie.getMovie().getName());

                    // assert on the no. of reviews for the movie
                    assertEquals(2, movie.getReviewList().size());
                })
                .assertNext(movie -> {
                    // assert name of the movie
                    assertEquals("Dark Knight Rises", movie.getMovie().getName());

                    // assert on the no. of reviews for the movie
                    assertEquals(2, movie.getReviewList().size());
                })
                .verifyComplete();
    }

    @Test
    void getMovieByID() {
        // given
        long movieID = 1000;

        // when
        var movieMono = movieReactiveService.getMovieByID(movieID);

        // then
        StepVerifier.create(movieMono)
                .assertNext(movie -> {
                    assertEquals("Batman Begins", movie.getMovie().getName());
                    assertEquals(2, movie.getReviewList().size());
                })
                .verifyComplete();
    }
}