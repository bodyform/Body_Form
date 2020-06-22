package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.State;
import javassist.tools.rmi.ObjectNotFoundException;

public interface StateService {

	List<State> findAll();

	State findById(Integer id) throws ObjectNotFoundException;

	State save(State state);

	State update(Integer id, State state) throws ObjectNotFoundException;

	void delete(Integer id);
}