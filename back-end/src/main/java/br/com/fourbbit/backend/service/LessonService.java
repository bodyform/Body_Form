package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.Lesson;
import javassist.tools.rmi.ObjectNotFoundException;

public interface LessonService {

	List<Lesson> findAll();

	Lesson findById(Integer id) throws ObjectNotFoundException;

	Lesson save(Lesson lesson);

	Lesson update(Integer id, Lesson lesson) throws ObjectNotFoundException;

	void delete(Integer id);
}