package com.example.movie_rental.models;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Genre {
    private Long id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<Movie> movies;
}
