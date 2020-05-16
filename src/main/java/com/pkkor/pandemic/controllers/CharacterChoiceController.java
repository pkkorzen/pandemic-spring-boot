package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.dto.CharacterChoiceDTO;
import com.pkkor.pandemic.entities.player.Player;
import com.pkkor.pandemic.main.game.Game;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CharacterChoiceController {

    private PlayerService playerService;
    private Game game;

    @Autowired
    public CharacterChoiceController(PlayerService playerService, Game game) {
        this.playerService = playerService;
        this.game = game;
    }

    @PostMapping("/characterChoice")
    public void save(@RequestBody CharacterChoiceDTO characterChoiceDTO) {
        game.execute(characterChoiceDTO);
    }
}
