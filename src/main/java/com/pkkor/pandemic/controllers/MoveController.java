package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.main.game.Game;
import com.pkkor.pandemic.services.ConnectionsService;
import com.pkkor.pandemic.services.PlayerDiscardPileService;
import com.pkkor.pandemic.services.PlayerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MoveController {

    private Game game;
    private PlayerOrderService playerOrderService;

    @Autowired
    public MoveController(Game game, PlayerOrderService playerOrderService) {
        this.game = game;
        this.playerOrderService = playerOrderService;
    }

    @PostMapping("/move")
    public void move(@RequestBody String location) {
        game.move(location);
        AbstractPlayer activePlayer = playerOrderService.getActivePlayer();
        activePlayer.move(location);
    }
}
