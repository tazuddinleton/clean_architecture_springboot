package com.example.movie_rental.adopters.actors;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.usecases.CreateActor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    CreateActor createActor;
    public ActorsController(CreateActor createActor) {
        this.createActor = createActor;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody CreateActorCommand command) {
        var actor = this.createActor.createActor(command);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }
}
