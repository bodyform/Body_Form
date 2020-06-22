package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.City;
import br.com.fourbbit.backend.repository.CityRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City findById(Integer id) throws ObjectNotFoundException {
		Optional<City> city = cityRepository.findById(id);
		return city.orElseThrow(
				() -> new ObjectNotFoundException("Não foi encontrado id: " + id + ", tipo! " + City.class.getName()));
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City update(Integer id, City city) throws ObjectNotFoundException {
		City oldCity = findById(id);
		oldCity.setName(city.getName());
		oldCity.setDdd(city.getDdd());
		oldCity.setState(city.getState());
		oldCity.setDistricts(city.getDistricts());
		return save(oldCity);
	}

	@Override
	public void delete(Integer id) {
		cityRepository.deleteById(id);
	}
}