package com.aj.cursomc.services;

import javax.ejb.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.cursomc.domain.Pedido;
import com.aj.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Pedido pedido = repo.findOne(id);
		if (pedido == null) {
			throw new ObjectNotFoundException("Pedido não encontrada");
		}
		return pedido;
	}
}
