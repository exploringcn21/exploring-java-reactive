package com.exploringcn.project.movies.service;

import com.exploringcn.project.movies.domain.Movie;
import com.exploringcn.project.movies.domain.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieReactiveService {

    private MovieInfoService movieInfoService;
    private ReviewService reviewService;

    public MovieReactiveService(MovieInfoService movieInfoService, ReviewService reviewService) {
        this.movieInfoService = movieInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Movie> getAllMovies() {

        // 1. retrieve movies info
        var moviesInfoFlux = movieInfoService.retrieveMoviesFlux();

        // 2. retrieve movies reviews
        return moviesInfoFlux
                .flatMap(movieInfo -> {
                     Mono<List<Review>> listOfReviews = reviewService.retrieveReviewsFlux(movieInfo.getMovieInfoId()).collectList();
                     return listOfReviews.map(reviews -> new Movie(movieInfo, reviews));
                 });

    }
}
