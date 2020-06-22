package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.Professional;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ProfessionalService {

	List<Professional> findAll();

	List<Professional> findByActivitiesIdOrWorkAreasId(Integer activitiesId, Integer workAreasId);
	
	Professional findById(Integer id) throws ObjectNotFoundException;
	
	Professional save(Professional professional);

	Professional update(Integer id, Professional professional) throws ObjectNotFoundException;

	void delete(Integer id);
}