/**
 * 
 */
package com.capestart.cricketscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capestart.cricketscore.model.Team;

/**
 * @author Nirmal
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

	// @Query(value = "select * from Team t where t.teamName = 't.id'
	// ",nativeQuery=true)

	// @Query(value = "select * from Player p where p.teamName = 'team_id' ",
	// nativeQuery = true)
	// public List<Team> getByAllPlayers();

	/*
	 * @Query(value = " select * from Team t ",nativeQuery = true) public List<Team>
	 * getAllTeamPlayers();
	 */
	/*
	 * @Query(value = " select * from Team t where t.id='t.team_id' ", nativeQuery =
	 * true) public List<Player> getAllTeamPlayers( );
	 */
}
