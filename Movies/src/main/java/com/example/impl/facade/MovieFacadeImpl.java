package com.example.impl.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.model.ActorEntity;
import com.example.entity.model.MovieEntity;
import com.example.interf.beans.ActorDTO;
import com.example.interf.beans.MovieDTO;
import com.example.interf.facade.MovieFacade;


@Service
public class MovieFacadeImpl implements MovieFacade {
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Override
	public List<MovieDTO> getMovies(){
		List<MovieDTO> listMovieDTO = new ArrayList<>(); 
		List<MovieEntity> listMovieEntity = (List<MovieEntity>)movieDAO.findAll();
		for (MovieEntity movEntity : listMovieEntity) {
			MovieDTO movieDTO = new MovieDTO();
			movieDTO.setName(movEntity.getMovieName());
			movieDTO.setYear(movEntity.getYear());
			//if there are actors
			if(movEntity.getActors()!=null && !movEntity.getActors().isEmpty()) {
				List<ActorDTO> actorsListDTO = new ArrayList<>();
				for (ActorEntity actor : movEntity.getActors()) {
					ActorDTO  actorDTO = new ActorDTO();
					actorDTO.setName(actor.getActorName());
					actorDTO.setYear(actor.getYear());
					actorsListDTO.add(actorDTO);
				}			
				
				movieDTO.setActors(actorsListDTO);
			}
				
			listMovieDTO.add(movieDTO);
		}
		return listMovieDTO;
	}
	
	@Override
	public MovieDTO getDetailedMovie(String name) {
		MovieDTO movieDTO = new MovieDTO();

		try {
		 MovieEntity movieEntity =movieDAO.findById(name).get();
		 movieDTO.setName(movieEntity.getMovieName());
		 movieDTO.setYear(movieEntity.getYear());
		 
		if(movieEntity.getActors()!=null && !movieEntity.getActors().isEmpty()) {
			List<ActorDTO> actorsListDTO = new ArrayList<>();
			for (ActorEntity actor : movieEntity.getActors()) {
					ActorDTO  actorDTO = new ActorDTO();
					actorDTO.setName(actor.getActorName());
					actorDTO.setYear(actor.getYear());
					actorsListDTO.add(actorDTO);
			}			
				
			movieDTO.setActors(actorsListDTO);
		}
				

		 
		 } catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
			
		}
		
		
		 return movieDTO;
		
	}
	
	@Override
	public void createMovie(String name,int year, List<ActorDTO> actors) {
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setMovieName(name);
		movieEntity.setYear(year);
		if (actors != null && !actors.isEmpty()) {
			List<ActorEntity> actorsList = new ArrayList<>();	
			for (ActorDTO actor : actors) {
				ActorEntity actNew = new ActorEntity();
				actNew.setActorName(actor.getName());
				actNew.setYear(actor.getYear());
				actorsList.add(actNew);
			}
			Set<ActorEntity> actorSet = new HashSet<ActorEntity>(actorsList);
			movieEntity.setActors(actorSet);
		}
		
		movieDAO.save(movieEntity);
		
	}

}
