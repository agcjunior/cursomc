package com.aj.cursomc.services;

import javax.ejb.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.cursomc.domain.Categoria;
import com.aj.cursomc.repositories.CategoriaRepository;

import javassist.NotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Categoria categoria = repo.findOne(id);
		if (categoria == null) {
			throw new ObjectNotFoundException("Categoria não encontrada");
		}
		return categoria;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		find(obj.getId());
		return repo.save(obj);
	}
}
