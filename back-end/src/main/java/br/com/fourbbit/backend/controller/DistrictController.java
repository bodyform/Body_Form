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

import br.com.fourbbit.backend.entity.District;
import br.com.fourbbit.backend.service.DistrictServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("districts")
public class DistrictController {

	@Autowired
	private DistrictServiceImpl districtServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<District>> list() {
		return ResponseEntity.ok(districtServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<District> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(districtServiceImpl.findById(id));
	}

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<District> save(@RequestBody District district) {
		return ResponseEntity.ok(districtServiceImpl.save(district));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<District> update(@PathVariable("id") Integer id, @RequestBody District district)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(districtServiceImpl.update(id, district));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		districtServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}