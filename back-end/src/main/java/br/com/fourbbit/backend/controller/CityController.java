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

import br.com.fourbbit.backend.entity.City;
import br.com.fourbbit.backend.service.CityServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("city")
public class CityController {

	@Autowired
	private CityServiceImpl cityServiceImpl;

	@GetMapping("lista")
	public ResponseEntity<List<City>> list() {
		return ResponseEntity.ok(cityServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<City> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(cityServiceImpl.findById(id));
	}
	
	@PostMapping(value= "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> save(@RequestBody City city) {
		return ResponseEntity.ok(cityServiceImpl.save(city));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> update(@PathVariable("id") Integer id, @RequestBody City city)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(cityServiceImpl.update(id, city));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		cityServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}