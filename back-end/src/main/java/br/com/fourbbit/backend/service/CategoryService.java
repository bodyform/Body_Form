package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.Category;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CategoryService {

	List<Category> findAll();

	Category findById(Integer id) throws ObjectNotFoundException;

	Category findByName(String name);
	
	Category save(Category category);

	Category update(Integer id, Category category) throws ObjectNotFoundException;

	void delete(Integer id);
}