package com.aj.cursomc.services;

import javax.ejb.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.cursomc.domain.Cliente;
import com.aj.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Cliente cliente = repo.findOne(id);
		if (cliente == null) {
			throw new ObjectNotFoundException("Cliente não encontrada");
		}
		return cliente;
	}
}
