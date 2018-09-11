package com.example.entity.model;

import java.io.Serializable;

public class MovieActorIdPk implements Serializable {

	private static final long serialVersionUID = -2327585050035580685L; 
	
	
	
	private String movieName;
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
