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

import br.com.fourbbit.backend.entity.Professional;
import br.com.fourbbit.backend.service.ProfessionalServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professional")
public class ProfessionalController {

	@Autowired
	private ProfessionalServiceImpl professionalServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<Professional>> list() {
		return ResponseEntity.ok(professionalServiceImpl.findAll());
	}
	
	@GetMapping("find/{activitiesId}/{workAreasId}")
	public ResponseEntity<List<Professional>> find(@PathVariable("activitiesId") Integer  activitiesId, @PathVariable("workAreasId") Integer workAreasId) throws ObjectNotFoundException {
		return ResponseEntity.ok(professionalServiceImpl.findByActivitiesIdOrWorkAreasId(activitiesId, workAreasId));
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Professional> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(professionalServiceImpl.findById(id));
	}
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Professional> save(@RequestBody Professional professional) {
		return ResponseEntity.ok(professionalServiceImpl.save(professional));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Professional> update(@PathVariable("id") Integer id, @RequestBody Professional professional)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(professionalServiceImpl.update(id, professional));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		professionalServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}