package com.example.movie_rental.models;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class Movie {
    private Long id;
    private String name;
    private String rating;
    private String description;
    private Integer releaseYear;
    private BigDecimal rentalRate;
    private BigDecimal replacementCost;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Genre genre;
    private List<Actor> actors;
}
