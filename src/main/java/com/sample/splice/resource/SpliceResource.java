package com.sample.splice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.splice.repository.Customer;
import com.sample.splice.repository.UserRepository;

@RestController
@RequestMapping("/rest")
public class SpliceResource {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {

		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/customers/{user_id}")
	public ResponseEntity<Customer> getCustomerByID(@PathVariable("user_id") final int id) {

		return new ResponseEntity<>(userRepo.findCustomerById(id), HttpStatus.OK);
	}

	@PostMapping("/customer/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {

		return new ResponseEntity<>(userRepo.createCustomer(customer), HttpStatus.OK);
	}

	@PostMapping("/customer/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {

		return new ResponseEntity<>(userRepo.deleteCustomerById(id), HttpStatus.OK);
	}
	
	@PostMapping("/customer/update/{id}")
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") int id, @RequestBody Customer customer) {

		return new ResponseEntity<>(userRepo.updateCustomerEmailById(id, customer.getEmail()), HttpStatus.OK);
	}

}
