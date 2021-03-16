/**
 * 
 */
package com.capestart.cricketscore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capestart.cricketscore.model.Player;

/**
 * @author Nirmal
 *
 */
@Service
public interface PlayerService {
	
	public void addPlayer(Player player);
	
	public List<Player> getAllPlayerList();
	
	public Player getPlayerById(Long id);
	
	public void deletPlayerById(Long id);
	
	public Optional<Player> getByPlayerId(Long id);
	
	public Player getByName(String name);

	List<Player> findAllOrderByAverageAsc();
	
	public List<Player> getAllPlayersByTeam();	
}
