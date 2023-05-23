package com.example.movie_rental.db.actor;

import com.example.movie_rental.db.movie.MoviePersistenceModel;
import com.example.movie_rental.models.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "actor")
@Table(name = "actors", schema = "movie_rental")
public class ActorPersistenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToMany(mappedBy = "actors")
    private List<MoviePersistenceModel> movies;
}
