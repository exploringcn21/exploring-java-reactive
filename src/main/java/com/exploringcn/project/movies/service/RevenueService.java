package com.exploringcn.project.movies.service;

import com.exploringcn.project.movies.domain.Revenue;

import static com.exploringcn.project.movies.util.CommonUtil.delay;


public class RevenueService {

    public Revenue getRevenue(Long movieId){
        delay(1000); // simulating a network call ( DB or Rest call)
        return Revenue.builder()
                .movieInfoId(movieId)
                .budget(1000000)
                .boxOffice(5000000)
                .build();

    }
}