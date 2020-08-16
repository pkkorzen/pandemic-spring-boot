package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.entities.player.AbstractPlayer;
import com.pkkor.pandemic.main.game.Game;
import com.pkkor.pandemic.services.ConnectionsService;
import com.pkkor.pandemic.services.MoveChoiceService;
import com.pkkor.pandemic.services.PlayerDiscardPileService;
import com.pkkor.pandemic.services.PlayerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MoveController {

    private Game game;
    private PlayerOrderService playerOrderService;
    private MoveChoiceService moveChoiceService;

    @Autowired
    public MoveController(Game game, PlayerOrderService playerOrderService, MoveChoiceService moveChoiceService) {
        this.game = game;
        this.playerOrderService = playerOrderService;
        this.moveChoiceService = moveChoiceService;
    }

    @PostMapping("/move")
    public void move(@RequestBody String location) {
        game.move(location);
        AbstractPlayer activePlayer = playerOrderService.getActivePlayer();
        activePlayer.move(location);
    }

    @PostMapping("/chooseMove")
    public void chooseMove(@RequestBody String choice) {
        synchronized (moveChoiceService.getChoices()) {
            moveChoiceService.retainChoice(choice);
            moveChoiceService.getChoices().notify();
        }
    }

    @GetMapping("/moveOptions")
    public List<String> getMoveOptions() {
        return moveChoiceService.getChoices();
    }
}
