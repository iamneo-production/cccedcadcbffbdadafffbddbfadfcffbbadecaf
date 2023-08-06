package com.ltimindtree.iplbidding.services;

import java.util.ArrayList;
import java.util.List;

import com.ltimindtree.iplbidding.entities.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private List<Player> players;

    public PlayerService() {
        // Initialize with some hardcoded players for demonstration purposes
        players = new ArrayList<>();
        players.add(new Player(1L, "Player 1", 25, "Batsman", 100000));
        players.add(new Player(2L, "Player 2", 28, "Bowler", 80000));
        players.add(new Player(3L, "Player 3", 22, "All-Rounder", 120000));
        players.add(new Player(4L, "Player 4", 30, "Batsman", 90000));
    }

    public List<Player> getAllPlayers() {
        return players;
    }
}
