package com.tjones.bbbl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tjones.bbbl.models.Client;
import com.tjones.bbbl.repositories.ClientRepository;



@Service
public class ClientService {
	
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		
		this.clientRepository = clientRepository;
	}
	
	
	public List<Client> allClients(){
		return clientRepository.findAll();	
	}
	
	public Client findClient(Long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);
		if(optionalClient.isPresent()) {
			return optionalClient.get();
		}
		else {
			return null;
		}
	}
	
	
	public Client createClient(Client baby) {
		return clientRepository.save(baby);
	}
	
	public Client updateClient(Client baby) {
		return clientRepository.save(baby);
	}
	
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

}
