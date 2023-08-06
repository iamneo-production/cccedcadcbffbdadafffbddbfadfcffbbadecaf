package com.ltimindtree.iplbidding.repositories;

import com.ltimindtree.iplbidding.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByCategoryAndSoldFalse(String category);
}
