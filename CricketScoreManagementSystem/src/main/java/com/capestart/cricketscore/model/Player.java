/**
 * 
 */
package com.capestart.cricketscore.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Nirmal
 *
 */
@Entity
@Table(name = "player")
public class Player implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String birth_place;

	private String batting_style;

//	private String bowling_style;

	private Long matches;

	private Long runs;

	private Double average;

	private Double strike_rate;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

	public Player() {
		super();
	}

	public Player(String name, String birth_place, String batting_style, Long matches, Long runs, Double average,
			Double strike_rate, Team team) {
		super();

		this.name = name;
		this.birth_place = birth_place;
		this.batting_style = batting_style;
		this.matches = matches;
		this.runs = runs;
		this.average = average;
		this.strike_rate = strike_rate;
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getBatting_style() {
		return batting_style;
	}

	public void setBatting_style(String batting_style) {
		this.batting_style = batting_style;
	}

	public Long getMatches() {
		return matches;
	}

	public void setMatches(Long matches) {
		this.matches = matches;
	}

	public Long getRuns() {
		return runs;
	}

	public void setRuns(Long runs) {
		this.runs = runs;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getStrike_rate() {
		return strike_rate;
	}

	public void setStrike_rate(Double strike_rate) {
		this.strike_rate = strike_rate;
	}
	
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", birth_place=" + birth_place + ", batting_style="
				+ batting_style + ", matches=" + matches + ", runs=" + runs + ", average=" + average + ", strike_rate="
				+ strike_rate + ", team=" + team + "]";
	}

	

}
