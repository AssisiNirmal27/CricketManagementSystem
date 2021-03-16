/**
 * 
 */
package com.capestart.cricketscore.service;

import java.util.List;
import java.util.Optional;

import com.capestart.cricketscore.model.Player;
import com.capestart.cricketscore.model.Team;

/**
 * @author Nirmal
 *
 */

public interface TeamService {

	public void addTeam(Team team);

	public List<Team> getAllTeamList();

	public Optional<Team> getTeamById(Long id);
	
	public void updateTeamInformation(Team team);
	
	public void deleteTeamById(Long id);
	
	//public List<Team> getAllTeamAndPlayersList();
	//public List<Player> getAllPlayersByTeam();

}
