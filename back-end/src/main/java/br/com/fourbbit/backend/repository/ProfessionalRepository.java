package br.com.fourbbit.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fourbbit.backend.entity.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

	List<Professional> findByActivitiesIdOrWorkAreasId(Integer activitiesId, Integer workAreasId);
}