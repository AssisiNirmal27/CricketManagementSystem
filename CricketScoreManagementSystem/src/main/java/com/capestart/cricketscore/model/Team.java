/**
 * 
 */
package com.capestart.cricketscore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nirmal
 *
 */
@Entity
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String teamName;
	@JsonIgnore
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Player> player;

	public Team() {
		super();
	}

	public Team(String teamName, List<Player> player) {
		super();
		this.teamName = teamName;
		this.player = player;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", player=" + player + "]";
	}

}
