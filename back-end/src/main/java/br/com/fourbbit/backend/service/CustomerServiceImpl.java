package br.com.fourbbit.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fourbbit.backend.entity.Customer;
import br.com.fourbbit.backend.repository.CustomerRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Integer id) throws ObjectNotFoundException {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.orElseThrow(() -> new ObjectNotFoundException(
				"Não foi encontrado id: " + id + ", tipo! " + Customer.class.getName()));
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Integer id, Customer customer) throws ObjectNotFoundException {
		Customer oldCustomer = findById(id);
		oldCustomer.setUser(customer.getUser());
		return save(oldCustomer);
	}

	@Override
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
}