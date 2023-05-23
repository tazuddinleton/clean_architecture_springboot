package com.example.movie_rental.db.genre;

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
@Entity(name = "genre")
@Table(name = "genre", schema = "movie_rental")
public class GenrePersistenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToMany(targetEntity = MoviePersistenceModel.class, cascade = CascadeType.ALL, mappedBy = "genre")
    private List<MoviePersistenceModel> movies;
}
