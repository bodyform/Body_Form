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

import br.com.fourbbit.backend.entity.Activity;
import br.com.fourbbit.backend.service.ActivityServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("activity")
public class ActivityController {

	@Autowired
	private ActivityServiceImpl activityServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<Activity>> list() {
		return ResponseEntity.ok(activityServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Activity> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(activityServiceImpl.findById(id));
	}

	@PostMapping(value = "save" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Activity> save(@RequestBody Activity activity) {
		return ResponseEntity.ok(activityServiceImpl.save(activity));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Activity> update(@PathVariable("id") Integer id, @RequestBody Activity activity)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(activityServiceImpl.update(id, activity));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		activityServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}