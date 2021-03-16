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
import com.capestart.cricketscore.repository.PlayersRepository;
import com.capestart.cricketscore.service.PlayerService;

/**
 * @author Nirmal
 *
 */

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayersRepository playersRepository;

	@Override
	public void addPlayer(Player player) {
		playersRepository.saveAndFlush(player);
	}

	@Override
	public List<Player> getAllPlayerList() {
		return playersRepository.findAll();
	}

	@Override
	public Player getPlayerById(Long id) {
		return playersRepository.findByIdValue(id);
	}

	@Override
	public void deletPlayerById(Long id) {
		playersRepository.deleteById(id);
	}

	@Override
	public Player getByName(String name) {

		return playersRepository.findByName(name);
	}

	@Override
	public Optional<Player> getByPlayerId(Long id) {
		// TODO Auto-generated method stub
		return playersRepository.findById(id);
	}

	@Override
	public List<Player> findAllOrderByAverageAsc() {

		return playersRepository.findAllOrderByAverage();
	}

	@Override
	public List<Player> getAllPlayersByTeam() {
		return playersRepository.getAllTeamPlayers();
	}

}
