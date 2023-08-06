import { Component, OnInit } from '@angular/core';
import { OrganizerService } from '../services/organizer.service';
import { Player } from '../../models/player.model';
import { Team } from '../../models/team.model';

@Component({
  selector: 'app-organizer',
  templateUrl: './organizer.component.html',
  styleUrls: ['./organizer.component.css']
})
export class OrganizerComponent implements OnInit {
  unsoldPlayers: Player[]=[];
  teams: Team[]=[];
  categories: string[]=[]; // Assuming you have a list of categories from the backend
  selectedCategory: string = '';

  constructor(private organizerService: OrganizerService) { }

  ngOnInit(): void {
    this.getUnsoldPlayers();
    this.getTeams();
    this.getCategories();
  }

  getUnsoldPlayers(): void {
    this.organizerService.getUnsoldPlayers().subscribe((players) => {
      this.unsoldPlayers = players;
    });
  }

  getTeams(): void {
    this.organizerService.getTeams().subscribe((teams) => {
      this.teams = teams;
    });
  }

  getCategories(): void {
    // You need to implement a service method to fetch the categories from the backend.
    // For example: this.organizerService.getCategories().subscribe((categories) => this.categories = categories);
  }

  filterPlayers(): void {
    if (this.selectedCategory) {
      this.unsoldPlayers = this.unsoldPlayers.filter((player) => player.category === this.selectedCategory);
    } else {
      this.getUnsoldPlayers();
    }
  }

  assignPlayerToTeam(player: Player): void {
    // Implement the assign player to team functionality here
  }

  releasePlayerFromTeam(team: Team): void {
    // Implement the release player from team functionality here
  }
}
