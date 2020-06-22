package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.Activity;
import br.com.fourbbit.backend.repository.ActivityRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> findAll() {
		return activityRepository.findAll();
	}

	@Override
	public Activity findById(Integer id) throws ObjectNotFoundException {
		Optional<Activity> activity = activityRepository.findById(id);
		return activity.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + Activity.class.getName()));
	}

	@Override
	public Activity save(Activity activity) {
		return activityRepository.save(activity);
	}

	@Override
	public Activity update(Integer activityId, Activity activity) throws ObjectNotFoundException {
		Activity oldActivity = findById(activityId);
		oldActivity.setName(activity.getName());
		oldActivity.setDescription(activity.getDescription());
		return save(oldActivity);
	}

	@Override
	public void delete(Integer id) {
		 activityRepository.deleteById(id);
	}
}