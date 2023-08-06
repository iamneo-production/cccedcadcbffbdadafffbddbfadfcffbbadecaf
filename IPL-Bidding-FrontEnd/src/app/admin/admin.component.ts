import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { Team } from '../../models/team.model';
import { Player } from '../../models/player.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  teams: Team[] = [];
  players: Player[] = [];

  newTeam: Team = { name: '', maximumBudget: 0 };
  newPlayer: Player = { name: '', age: 0 };

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.getTeams();
    this.getPlayers();
  }

  getTeams(): void {
    this.adminService.getTeams().subscribe((teams) => {
      this.teams = teams;
    });
  }

  createTeam(): void {
    this.adminService.createTeam(this.newTeam).subscribe(() => {
      this.getTeams();
      this.newTeam = { name: '', maximumBudget: 0 };
    });
  }

  editTeam(team: Team): void {
    // Implement the edit team functionality here
  }

  deleteTeam(teamId: number): void {
    this.adminService.deleteTeam(teamId).subscribe(() => {
      this.getTeams();
    });
  }

  getPlayers(): void {
    this.adminService.getPlayers().subscribe((players) => {
      this.players = players;
    });
  }

  createPlayer(): void {
    this.adminService.createPlayer(this.newPlayer).subscribe(() => {
      this.getPlayers();
      this.newPlayer = { name: '', age: 0 };
    });
  }

  editPlayer(player: Player): void {
    // Implement the edit player functionality here
  }

  deletePlayer(playerId: number): void {
    this.adminService.deletePlayer(playerId).subscribe(() => {
      this.getPlayers();
    });
  }
}
