package com.example.interf.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.interf.beans.ActorDTO;
import com.example.interf.beans.MovieDTO;

@Service
public interface MovieFacade {
	
	public List<MovieDTO> getMovies();
	
	public MovieDTO getDetailedMovie(String name);
	
	public void createMovie(String name,int year, List<ActorDTO> actors);

}
