package com.ltimindtree.iplbidding.repositories;

import com.ltimindtree.iplbidding.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Custom query methods (if required)
}

