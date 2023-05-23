package com.example.movie_rental.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Genre {
    private Long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private List<Movie> movies;
}
