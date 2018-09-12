package com.example.interf.beans;

import java.util.List;

public class MovieDTO {
	
	private String name;
	private int year;
	private List<ActorDTO> actors;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public int getYear() {
		
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	
	}
	public List<ActorDTO> getActors() {
		return actors;
	}
	public void setActors(List<ActorDTO> actors) {
		this.actors = actors;

	}
	


}
