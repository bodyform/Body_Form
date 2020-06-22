package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.City;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CityService {

	List<City> findAll();

	City findById(Integer id) throws ObjectNotFoundException;

	City save(City city);

	City update(Integer id, City city) throws ObjectNotFoundException;

	void delete(Integer id);
}