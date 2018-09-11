package com.example.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity(name="MOVIE_ACTOR")
@IdClass(MovieActorIdPk.class)
public class MovieActorEntity {
	
	@Id
	@Column(nullable=false,name="MOVIE_NAME")
	private String movieName;
	
	@Id
	@Column(nullable=false,name="ACTOR_NAME")
	private String actorName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
	
	
	

}
