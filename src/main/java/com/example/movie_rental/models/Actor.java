package com.example.movie_rental.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Actor {
    private Long id;
    private String firstName;
    private String lastName;
    private Date createdAt;
    private Date updatedAt;
}