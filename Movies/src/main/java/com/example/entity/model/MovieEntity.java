package com.example.entity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity(name="MOVIES")
public class MovieEntity {
	
	@Id 
	@Column(nullable = false, name = "MOVIE_NAME")
	private String movieName;
	
	@Column(nullable = false,name="YEAR")
	private int year;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="MOVIE_ACTOR" , joinColumns = { @JoinColumn(name = "MOVIE_NAME")},
			inverseJoinColumns = { @JoinColumn(name = "ACTOR_NAME") })
	private Set<ActorEntity> actors = new HashSet<>();
	

	public Set<ActorEntity> getActors() {
		return actors;
	}

	public void setActors(Set<ActorEntity> actors) {
		this.actors = actors;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	

}
