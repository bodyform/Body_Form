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

import br.com.fourbbit.backend.entity.State;
import br.com.fourbbit.backend.service.StateServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("states")
public class StateController {

	@Autowired
	private StateServiceImpl stateServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<State>> list() {
		return ResponseEntity.ok(stateServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<State> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(stateServiceImpl.findById(id));
	}

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<State> save(@RequestBody State state) {
		return ResponseEntity.ok(stateServiceImpl.save(state));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<State> update(@PathVariable("id") Integer id, @RequestBody State state)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(stateServiceImpl.update(id, state));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		stateServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}