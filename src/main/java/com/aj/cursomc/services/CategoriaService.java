package com.aj.cursomc.services;

import java.util.List;

import javax.ejb.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aj.cursomc.domain.Categoria;
import com.aj.cursomc.repositories.CategoriaRepository;
import com.aj.cursomc.services.exceptions.DataIntegrityExcpeption;

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
	
	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExcpeption("Não posso excluir a categoria com produtos");
		}		
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
