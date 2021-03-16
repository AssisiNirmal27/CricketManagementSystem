/**
 * 
 */
package com.capestart.cricketscore.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capestart.cricketscore.model.Player;
import com.capestart.cricketscore.model.Team;
import com.capestart.cricketscore.repository.TeamRepository;
import com.capestart.cricketscore.service.TeamService;

/**
 * @author Nirmal
 *
 */

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void addTeam(Team team) {

		teamRepository.saveAndFlush(team);
	}

	@Override
	public List<Team> getAllTeamList() {

		return teamRepository.findAll();
	}

	
	@Override
	public void updateTeamInformation(Team team) {
		teamRepository.saveAndFlush(team);
	}

	@Override
	public Optional<Team> getTeamById(Long id) {

		return teamRepository.findById(id);
	}

	@Override
	public void deleteTeamById(Long id) {
		teamRepository.deleteById(id);
	}

	/*
	 * @Override public List<Player> getAllPlayersByTeam() { // TODO Auto-generated
	 * method stub return teamRepository.getAllTeamPlayers(); }
	 */

	/*
	 * @Override public List<Team> getAllTeamAndPlayersList() { // TODO
	 * Auto-generated method stub return teamRepository.getByAllPlayers(); }
	 * 
	 */}
