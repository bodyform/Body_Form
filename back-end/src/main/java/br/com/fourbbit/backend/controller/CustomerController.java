package br.com.fourbbit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fourbbit.backend.entity.Customer;
import br.com.fourbbit.backend.service.CustomerServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@GetMapping("list")
	public ResponseEntity<List<Customer>> List() {
		return ResponseEntity.ok(customerServiceImpl.findAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		return ResponseEntity.ok(customerServiceImpl.findById(id));
	}

	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerServiceImpl.save(customer));
	}

	@PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> update(@PathVariable("id") Integer id, @RequestBody Customer customer)
			throws ObjectNotFoundException {
		return ResponseEntity.ok(customerServiceImpl.update(id, customer));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		customerServiceImpl.delete(id);
		return ResponseEntity.noContent().build();
	}
}