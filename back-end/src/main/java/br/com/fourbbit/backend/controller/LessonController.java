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

import br.com.fourbbit.backend.entity.Lesson;
import br.com.fourbbit.backend.service.LessonServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("lesson")
public class LessonController {

	@Autowired
	private LessonServiceImpl lessonServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<Lesson>> list() {
		return ResponseEntity.ok(lessonServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Lesson> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(lessonServiceImpl.findById(id));
	}

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lesson> save(@RequestBody Lesson lesson) {
		return ResponseEntity.ok(lessonServiceImpl.save(lesson));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lesson> update(@PathVariable("id") Integer id, @RequestBody Lesson lesson)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(lessonServiceImpl.update(id, lesson));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		lessonServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}