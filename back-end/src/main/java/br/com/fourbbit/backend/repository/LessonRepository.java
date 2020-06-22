package br.com.fourbbit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fourbbit.backend.entity.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}