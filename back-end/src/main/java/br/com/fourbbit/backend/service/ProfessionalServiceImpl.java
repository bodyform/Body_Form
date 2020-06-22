package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.Professional;
import br.com.fourbbit.backend.repository.ProfessionalRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

	@Autowired
	private ProfessionalRepository professionalRepository;

	@Override
	public List<Professional> findAll() {
		return professionalRepository.findAll();
	}
	
	@Override
	public List<Professional> findByActivitiesIdOrWorkAreasId(Integer activitiesId, Integer workAreasId) {
		return professionalRepository.findByActivitiesIdOrWorkAreasId(activitiesId, workAreasId);
	}

	@Override
	public Professional findById(Integer id) throws ObjectNotFoundException {
		Optional<Professional> professional = professionalRepository.findById(id);
		return professional.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + Professional.class.getName()));
	}

	@Override
	public Professional save(Professional professional) {
		return professionalRepository.save(professional);
	}

	@Override
	public Professional update(Integer id, Professional professional) throws ObjectNotFoundException {
		Professional oldProfessional = findById(id);
		oldProfessional.setUser(professional.getUser());
		oldProfessional.setActivities(professional.getActivities());
		oldProfessional.setFormations(professional.getFormations());
		oldProfessional.setWorkAreas(professional.getWorkAreas());
		oldProfessional.setExperiences(professional.getExperiences());
		return save(oldProfessional);
	}

	@Override
	public void delete(Integer id) {
		professionalRepository.deleteById(id);
	}
}