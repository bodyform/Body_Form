package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.Activity;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ActivityService {

	List<Activity> findAll();

	Activity findById(Integer id) throws ObjectNotFoundException;

	Activity save(Activity activity);

	Activity update(Integer id, Activity activity) throws ObjectNotFoundException;

	void delete(Integer id);
}