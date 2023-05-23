package com.example.movie_rental.db.movie;

import com.example.movie_rental.db.actor.ActorPersistenceModel;
import com.example.movie_rental.db.genre.GenrePersistenceModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movie")
@Table(name = "movies", schema = "movie_rental")
public class MoviePersistenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rating;
    private String description;
    private Integer releaseYear;
    private BigDecimal rentalRate;
    private BigDecimal replacementCost;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenrePersistenceModel genre;
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            schema = "movie_rental",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorPersistenceModel> actors;
}
