package com.example.movie_rental.models;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
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
    private Genre genre;
    private List<Actor> actors;
}
