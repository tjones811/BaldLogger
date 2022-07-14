package com.tjones.bbbl.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tjones.bbbl.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	List<Client> findAll();

}

//