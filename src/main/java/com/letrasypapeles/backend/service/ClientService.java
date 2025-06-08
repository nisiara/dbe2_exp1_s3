package com.letrasypapeles.backend.service;

import com.letrasypapeles.backend.entity.Client;
import com.letrasypapeles.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> obtenerTodos() {
		return clientRepository.findAll();
	}

	public Optional<Client> obtenerPorId(Long id) {
		return clientRepository.findById(id);
	}

	public Optional<Client> obtenerPorEmail(String name) {
		return clientRepository.findByName(name);
	}

}
