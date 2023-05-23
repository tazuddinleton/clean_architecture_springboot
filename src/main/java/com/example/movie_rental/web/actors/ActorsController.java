package com.example.movie_rental.web.actors;

import com.example.movie_rental.models.Actor;
import com.example.movie_rental.uc.actor.CreateActorUseCase;
import com.example.movie_rental.uc.actor.ReadActorUseCase;
import com.example.movie_rental.uc.actor.UpdateActorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    CreateActorUseCase createActor;
    UpdateActorUseCase updateActor;
    ReadActorUseCase readActor;
    public ActorsController(CreateActorUseCase createActor, UpdateActorUseCase updateActor, ReadActorUseCase readActor) {
        this.createActor = createActor;
        this.updateActor = updateActor;
        this.readActor = readActor;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody CreateActorCommand command) {
        var actor = this.createActor.createActor(command);
        return new ResponseEntity<>(actor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> readActor() {
        return new ResponseEntity<>(this.readActor.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Actor> updateActor(@RequestBody UpdateActorCommand command) {
        var optionalActor = this.updateActor.update(command);
        return optionalActor
                .map(actor -> new ResponseEntity<>(actor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
