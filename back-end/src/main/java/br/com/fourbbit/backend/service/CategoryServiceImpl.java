package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.Category;
import br.com.fourbbit.backend.repository.CategoryRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	@Override
	public Category findById(Integer id) throws ObjectNotFoundException {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + Category.class.getName()));
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Integer id, Category category) throws ObjectNotFoundException {
		Category oldCategory = findById(id);
		oldCategory.setName(category.getName());
		oldCategory.setDescription(category.getDescription());
		oldCategory.setActivities(category.getActivities());
		return save(oldCategory);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
}