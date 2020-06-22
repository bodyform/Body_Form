package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.State;
import br.com.fourbbit.backend.repository.StateRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	@Override
	public State findById(Integer id) throws ObjectNotFoundException {
		Optional<State> state = stateRepository.findById(id);
		return state.orElseThrow(
				() -> new ObjectNotFoundException("Não foi encontrado id: " + id + ", tipo! " + State.class.getName()));
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

	@Override
	public State update(Integer id, State state) throws ObjectNotFoundException {
		State oldState = findById(id);
		oldState.setName(state.getName());
		oldState.setUf(state.getUf());
		oldState.setCities(state.getCities());
		return save(oldState);
	}

	@Override
	public void delete(Integer id) {
		stateRepository.deleteById(id);
	}
}