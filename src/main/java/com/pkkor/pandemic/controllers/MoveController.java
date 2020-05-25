package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.main.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MoveController {

    private Game game;

    @Autowired
    public MoveController(Game game) {
        this.game = game;
    }

    @PostMapping("/move")
    public void move(@RequestBody String location) {
        game.move(location);
    }
}
