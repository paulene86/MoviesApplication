package com.example.entity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="ACTORS")
public class ActorEntity {
	
	@Id
	@Column(nullable=false, name="ACTOR_NAME")
	private String actorName;
	
	@Column(nullable=false, name="YEAR")
    private int year;	
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "actors")
	private Set<MovieEntity> movies = new HashSet<>();


	public String getActorName() {
		return actorName;
	}

	public Set<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(Set<MovieEntity> movies) {
		this.movies = movies;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}



}
