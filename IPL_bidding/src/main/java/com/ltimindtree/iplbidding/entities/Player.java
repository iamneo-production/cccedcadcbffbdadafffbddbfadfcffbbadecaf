package com.ltimindtree.iplbidding.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String category;
    private double biddingPrice;
    private boolean sold;
    private String email;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(Long id, String name, int age, String category, double biddingPrice) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.category = category;
        this.biddingPrice = biddingPrice;
    }

    // Constructors, getters, setters
}
