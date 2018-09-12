package com.example.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interf.beans.ActorDTO;
import com.example.interf.beans.MovieDTO;
import com.example.interf.facade.MovieFacade;



@RestController
@RequestMapping("/")
public class MoviesController {
	
	
	List <ActorDTO> listActors = new ArrayList<>();
	
	{
		ActorDTO actor1 = new ActorDTO();
		actor1.setName("Luigi");
		actor1.setYear(25);
		ActorDTO actor2 = new ActorDTO();
		actor2.setName("Mario");
		actor2.setYear(30);
		ActorDTO actor3 = new ActorDTO();
		actor3.setName("Carlos");
		actor3.setYear(40);
		
		listActors.add(actor1);
		listActors.add(actor2);
		listActors.add(actor3);
	}
		
	
	
	
	
	@Autowired 
	MovieFacade movieFacade;

	@RequestMapping(value="moviesList", method=GET)
	public  @ResponseBody List<MovieDTO> getMoviesList(){
		return movieFacade.getMovies();
	}
	
	@RequestMapping(value="movie",method=POST)
	public String createMovie(@RequestBody MovieDTO movieDTO) {	
		
		try {
			movieFacade.createMovie(movieDTO.getName(), movieDTO.getYear(), movieDTO.getActors());
		} catch (Exception e) {
			return e.getMessage();
		}			
		return 	"OK";

	}
	
	@RequestMapping(value="movie/{name}",method=GET)
	public @ResponseBody MovieDTO getMovie(@PathVariable  String name) {
		
		MovieDTO movieDTO =  movieFacade.getDetailedMovie(name);
		if(movieDTO!=null && movieDTO.getName()!=null)
			return movieDTO;
		else {
			//mensajes de error
			return null;
		}
	}
	
	@RequestMapping(value="actorsList", method=GET)
	public  @ResponseBody List<ActorDTO> getActorsList(){
		return listActors;
	}


}
