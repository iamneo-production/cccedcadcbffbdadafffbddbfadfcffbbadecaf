package com.ltimindtree.iplbidding.controllers;

import com.ltimindtree.iplbidding.entities.Player;
import com.ltimindtree.iplbidding.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {
    private OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    // Endpoint to fetch unsold players by category
    @GetMapping("/unsold-players")
    public List<Player> getUnsoldPlayersByCategory(@RequestParam String category) {
        return organizerService.getUnsoldPlayersByCategory(category);
    }

    // Endpoint to assign an unsold player to a team
    @PostMapping("/assign-player")
    public ResponseEntity<String> assignPlayerToTeam(@RequestParam Long playerId, @RequestParam Long teamId) {
        organizerService.assignPlayerToTeam(playerId, teamId);
        return ResponseEntity.ok("Player assigned to the team successfully");
    }

    // Endpoint to release a player from a team
    @PutMapping("/release-player/{playerId}")
    public ResponseEntity<String> releasePlayerFromTeam(@PathVariable Long playerId) {
        organizerService.releasePlayerFromTeam(playerId);
        return ResponseEntity.ok("Player released from the team successfully");
    }
}


