package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.District;
import javassist.tools.rmi.ObjectNotFoundException;

public interface DistrictService {

	List<District> findAll();

	District findById(Integer id) throws ObjectNotFoundException;

	District save(District district);

	District update(Integer id, District district) throws ObjectNotFoundException;

	void delete(Integer id);
}