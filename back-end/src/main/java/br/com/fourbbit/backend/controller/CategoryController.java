package br.com.fourbbit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fourbbit.backend.entity.Category;
import br.com.fourbbit.backend.service.CategoryServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<Category>> list() {
		return ResponseEntity.ok(categoryServiceImpl.findAll());
	}

	@GetMapping("findByName/{name}")
	public ResponseEntity<Category> find(@PathVariable("name") String name) throws ObjectNotFoundException {
		return ResponseEntity.ok(categoryServiceImpl.findByName(name));
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Category> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(categoryServiceImpl.findById(id));
	}

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> save(@RequestBody Category category) {
		return ResponseEntity.ok(categoryServiceImpl.save(category));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(categoryServiceImpl.update(id, category));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		categoryServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}