/**
 * 
 */
package com.capestart.cricketscore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capestart.cricketscore.model.Player;
import com.capestart.cricketscore.service.PlayerService;

/**
 * @author Nirmal
 *
 */

@RestController
@Component
@RequestMapping("/restApi/")
public class PlayerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

	@Autowired
	private PlayerService playerService;

	/*
	 * Get All Player Information
	 * 
	 * @return
	 */

	@GetMapping("getAllPlayerInformation")
	public List<Player> getAllPlayerInformation() throws JSONException {
		LOGGER.info("Get All PlayerInformation");
		List<Player> playerList = playerService.getAllPlayerList();
		return playerList;

	}

	/*
	 * Create Player Information
	 * 
	 * @return
	 */
	@PostMapping("playerInformation/create")
	public String createPlayerInformation(@RequestBody Player player) throws JSONException {
		LOGGER.info(" Create Player Information");
		if (player != null) {
			playerService.addPlayer(player);
		}
		return " Create Player SuccessFully!!!!";
	}

	/*
	 * Get Player Information By Player Id
	 * 
	 * @id
	 * 
	 * @return
	 */
	@GetMapping("playerInformation/find/{id}")
	public Player getPlayerInformationById(@PathVariable("id") Long id) throws JSONException {
		LOGGER.info("Get Player Information ById:");
		if (id != null) {
			Optional<Player> player = playerService.getByPlayerId(id);
			if (player != null) {
				return player.get();
			}

		}
		return null;

	}

	/*
	 * 
	 * Update Player Information
	 * 
	 * @return
	 */

	@PutMapping("playerInformation/update/{id}")
	public String updatePlayerInformation(@RequestBody Player player, @PathVariable("id") Long id)
			throws JSONException {
		if (id != null) {

			Player player1 = playerService.getPlayerById(id);
			if (player1.getId() == null) {
				return " User Id is Empty !!!";
			}
			player.setId(id);
			long run = player1.getRuns() + player.getRuns();
			player.setRuns(run);
			System.out.println("==========" + player.getMatches());
			long average = run / player.getMatches();
			System.out.println("AAAAAAAAAA:-->" + average);
			player.setAverage(Double.parseDouble(String.valueOf(average)));
			System.out.println("=====================" + player.getAverage());
			playerService.addPlayer(player);
		}
		return "update successFully!!!!";

	}

	/*
	 * Delete Player Information By Player Id
	 * 
	 * @id
	 * 
	 * @return
	 */

	@DeleteMapping("playerInformation/delete/{id}")
	public String deletePlayerInformationById(@PathVariable("id") Long id) throws JSONException {
		LOGGER.info("Delete PlayerInformation ByID:");
		JSONObject playerObject = new JSONObject();
		List<Player> playerLists = new ArrayList<Player>();
		Player player = playerService.getPlayerById(id);
		if (id != null) {
			playerService.deletPlayerById(player.getId());
			playerLists = playerService.getAllPlayerList();
			playerObject.put("success", true);
			playerObject.put("msg", "deleteSuccessFully!!!");
			playerObject.put("data", playerLists);
		}
		return playerObject.toString();
	}

	/*
	 * Player Information By Player Name
	 * 
	 * @Name
	 * 
	 * @return
	 */

	@GetMapping("playerInformationFindByName/{name}")
	public Player playerInformationFindByName(Model model, @PathVariable("name") String name) throws JSONException {
		LOGGER.info("Player Information Get By Name:");
		Player list = playerService.getByName(name);
		model.addAttribute("result", list);
		return list;

	}

	/*
	 * Player Information Based on Average
	 * 
	 * 
	 * @return
	 */

	@GetMapping("playerInformationByAverage")
	public List<Player> getAverageFindByPlayer() throws JSONException {
		LOGGER.info("Get Player Based On Average :");
		return playerService.findAllOrderByAverageAsc();
	}

	@GetMapping("playerInformationByTeam/{name}")
	public List<Player> getPlayerByTeam(@PathVariable(value = "name") String name) throws JSONException {
		LOGGER.info("Get Player By Team Name");
		return playerService.getAllPlayersByTeam();
	}

}
