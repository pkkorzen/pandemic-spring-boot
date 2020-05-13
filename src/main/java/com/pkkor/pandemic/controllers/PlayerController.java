package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> findAll() {
        return playerService.findAllPlayers();
    }

    @PostMapping("/players")
    void savePlayers(@RequestBody Player player) {
        playerService.savePlayer(player);
    }
}
