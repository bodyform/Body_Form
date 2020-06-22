package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.Lesson;
import br.com.fourbbit.backend.repository.LessonRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonRepository lessonRepository;

	@Override
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}

	@Override
	public Lesson findById(Integer id) throws ObjectNotFoundException {
		Optional<Lesson> lesson = lessonRepository.findById(id);
		return lesson.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + Lesson.class.getName()));
	}

	@Override
	public Lesson save(Lesson lesson) {
		return lessonRepository.save(lesson);
	}

	@Override
	public Lesson update(Integer id, Lesson lesson) throws ObjectNotFoundException {
		Lesson oldLesson = findById(id);
		oldLesson.setLocalDateTime(lesson.getLocalDateTime());
		oldLesson.setAdress(lesson.getAdress());
		oldLesson.setStatus(lesson.getStatus());
		return save(oldLesson);
	}

	@Override
	public void delete(Integer id) {
		lessonRepository.deleteById(id);
	}
}