package com.example.impl.facade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.model.MovieEntity;

@Repository
public interface MovieDAO extends CrudRepository<MovieEntity, String> {
	


	
	

}
