package com.ltimindtree.iplbidding.services;

import java.util.ArrayList;
import java.util.List;

import com.ltimindtree.iplbidding.entities.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private List<Team> teams;

    public TeamService() {
        // Initialize with some hardcoded teams for demonstration purposes
        teams = new ArrayList<>();
        teams.add(new Team(1L, "Team A", 1000000));
        teams.add(new Team(2L, "Team B", 900000));
        teams.add(new Team(3L, "Team C", 800000));
    }

    public List<Team> getAllTeams() {
        return teams;
    }
}

