package com.learnreactiveprogramming.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long movieId;
    private MovieInfo movie;
    private List<Review> reviewList;
    private Revenue revenue;

    public Movie(Long movieId, MovieInfo movie, List<Review> reviewList) {
        this.movieId = movieId;
        this.movie = movie;
        this.reviewList = reviewList;
    }
    public Movie(MovieInfo movieInfo, List<Review> reviewList) {
        this.movie = movieInfo;
        this.reviewList = reviewList;
    }
}
