package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.District;
import br.com.fourbbit.backend.repository.DistrictRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public List<District> findAll() {
		return districtRepository.findAll();
	}

	@Override
	public District findById(Integer id) throws ObjectNotFoundException {
		Optional<District> district = districtRepository.findById(id);
		return district.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + District.class.getName()));
	}
	
	@Override
	public District save(District district) {
		return districtRepository.save(district);
	}

	@Override
	public District update(Integer id, District district) throws ObjectNotFoundException {
		District oldDistrict = findById(id);
		oldDistrict.setName(district.getName());
		return save(oldDistrict);
	}

	@Override
	public void delete(Integer id) {
		districtRepository.deleteById(id);
	}
}