package com.pkkor.pandemic.controllers;

import com.pkkor.pandemic.dto.PlayerDTO;
import com.pkkor.pandemic.mappers.PlayerMapper;
import com.pkkor.pandemic.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/players")
    public List<PlayerDTO> findAll() {
        return playerService.findAllPlayers()
                .stream()
                .map(playerMapper::convert)
                .collect(Collectors.toList());
    }

    @PostMapping("/player/save")
    void savePlayers(@RequestBody PlayerDTO playerDTO) {
        playerService.savePlayer(playerMapper.convert(playerDTO));
    }
}
