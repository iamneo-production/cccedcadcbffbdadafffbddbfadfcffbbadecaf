package com.ltimindtree.iplbidding.controllers;

import com.ltimindtree.iplbidding.entities.Player;
import com.ltimindtree.iplbidding.entities.Team;
import com.ltimindtree.iplbidding.services.AdminService;
import com.ltimindtree.iplbidding.services.PlayerService;
import com.ltimindtree.iplbidding.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;
    private final PlayerService playerService;
    private final TeamService teamService;


    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @Autowired
    public AdminController(AdminService adminService, PlayerService playerService, TeamService teamService) {
        this.adminService = adminService;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    //    @PreAuthorize("hasRole('ADMIN')") // Only users with 'ADMIN' role can access this endpoint
    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team) {
        return adminService.createTeam(team);
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Endpoint to update an existing team
    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team updatedTeam) {
        return adminService.updateTeam(updatedTeam);
    }

    // Endpoint to delete a team by its ID
    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long teamId) {
        adminService.deleteTeam(teamId);
        return ResponseEntity.ok("Team deleted successfully");
    }

    // Endpoint to create a new player
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return adminService.createPlayer(player);
    }

    // Endpoint to update an existing player
    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player updatedPlayer) {
        return adminService.updatePlayer(updatedPlayer);
    }

    // Endpoint to delete a player by its ID
    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long playerId) {
        adminService.deletePlayer(playerId);
        return ResponseEntity.ok("Player deleted successfully");
    }
}


