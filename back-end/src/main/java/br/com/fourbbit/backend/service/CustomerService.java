package br.com.fourbbit.backend.service;

import java.util.List;

import br.com.fourbbit.backend.entity.Customer;
import javassist.tools.rmi.ObjectNotFoundException;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(Integer id) throws ObjectNotFoundException;

	Customer save(Customer customer);

	Customer update(Integer id, Customer customer) throws ObjectNotFoundException;

	void delete(Integer id);
}