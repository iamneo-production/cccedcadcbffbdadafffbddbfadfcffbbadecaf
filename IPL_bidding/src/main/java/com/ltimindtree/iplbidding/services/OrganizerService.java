package com.ltimindtree.iplbidding.services;

import com.ltimindtree.iplbidding.entities.Player;
import com.ltimindtree.iplbidding.entities.Team;
import com.ltimindtree.iplbidding.exceptions.ExceedsTeamBudgetException;
import com.ltimindtree.iplbidding.repositories.PlayerRepository;
import com.ltimindtree.iplbidding.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrganizerService {
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    private EmailService emailService;

    @Autowired
    public OrganizerService(PlayerRepository playerRepository, TeamRepository teamRepository, EmailService emailService) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.emailService = emailService;
    }

    // Method to fetch unsold players by category
    public List<Player> getUnsoldPlayersByCategory(String category) {
        return playerRepository.findByCategoryAndSoldFalse(category);
    }

    // Method to assign an unsold player to a team
    public void assignPlayerToTeam(Long playerId, Long teamId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new NoSuchElementException("Team not found"));

        double playerBiddingPrice = player.getBiddingPrice();
        double teamBudget = team.getMaximumBudget();

        if (playerBiddingPrice <= teamBudget) {
            player.setSold(true);
            player.setTeam(team);
            playerRepository.save(player);

            // Trigger email to the player
//            emailService.sendPlayerAssignmentEmail(player.getEmail(), player.getName(), team.getName());
        } else {
            throw new ExceedsTeamBudgetException("Exceeds team budget");
        }
    }

    // Method to release a player from a team
    public void releasePlayerFromTeam(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException("Player not found"));

        if (player.getTeam() != null) {
            player.setTeam(null);
            player.setSold(false);
            playerRepository.save(player);
        } else {
            throw new NoSuchElementException("Player is not assigned to any team");
        }
    }
}

