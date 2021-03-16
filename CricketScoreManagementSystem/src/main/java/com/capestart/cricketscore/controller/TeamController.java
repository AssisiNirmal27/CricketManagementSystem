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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capestart.cricketscore.model.Team;
import com.capestart.cricketscore.service.TeamService;

/**
 * @author Nirmal
 *
 */

@RestController
@RequestMapping(value = "/restApi/")
public class TeamController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	private TeamService teamService;

	/*
	 * Get All Team Information
	 * 
	 * @return
	 */
	@GetMapping("teamInformation/getAll")
	public List<Team> getAllTeamInformation() throws JSONException {
		LOGGER.info("Get All The Team Information");
		List<Team> teamList = teamService.getAllTeamList();
		return teamList;
	}

	/*
	 * Create Team Information
	 * 
	 * @return
	 */
	@PostMapping("teamInformation/create")
	public String createTeamInformation(@RequestBody Team team) throws JSONException {
		LOGGER.info("Create Team Information");
		if (team != null) {
			teamService.addTeam(team);
		}
		return "Create Successfully";
	}

	/*
	 * Get Team Information By Player Id
	 * 
	 * @id
	 * 
	 * @return
	 */
	@GetMapping("teamInformation/find/{id}")
	public Team getTeamInformationById(@PathVariable("id") Long id) throws JSONException {
		LOGGER.info(" Get Team Information By Id:");
		if (id != null) {
			Optional<Team> team = teamService.getTeamById(id);
			if (team != null) {
				return team.get();
			}
		}

		return null;
	}

	/*
	 * 
	 * Update Team Information
	 * 
	 * @return
	 */

	@PutMapping("teamInformation/update/{id}")
	public String updateTeamInformation(@RequestBody Team team, @PathVariable("id") Long id) throws JSONException {

		Optional<Team> currentTeam = teamService.getTeamById(id);
		if (currentTeam != null) {
			team.setId(id);
			teamService.addTeam(team);
		}
		return "Update Team Successfully!!!";
	}

	/*
	 * Delete Team Information By Player Id
	 * 
	 * @id
	 * 
	 * @return
	 */

	@DeleteMapping("teamInformation/delete/{id}")
	public String deleteTeamInformation(@PathVariable("id") Long id) throws JSONException {
		LOGGER.info("Delete TeamInformation By ID:");
		JSONObject teamObject = new JSONObject();
		List<Team> teams = new ArrayList<Team>();
		Optional<Team> team = teamService.getTeamById(id);
		if (team != null) {
			teamService.deleteTeamById(team.get().getId());
			teams = teamService.getAllTeamList();
			teamObject.put("result", true);
			teamObject.put("msg", "Delete TeamInformation SuccessFully!!!!");
			teamObject.put("data", teams);
		}
		return teamObject.toString();

	}
		
	/*
	 * @GetMapping("teamPlayersName/{name}") public List<Team>
	 * getAllTeamPlayersList(){ LOGGER.info("Get All players By Team:"); List<Team>
	 * list = teamService.getAllTeamAndPlayersList();
	 * 
	 * return list;
	 * 
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping("teamInformationByTeam/{name}") public List<Player>
	 * getPlayerByTeam(@PathVariable(value = "name") String name) throws
	 * JSONException { LOGGER.info("Get Player By Team Name"); return
	 * teamService.getAllPlayersByTeam(); }
	 */
}

