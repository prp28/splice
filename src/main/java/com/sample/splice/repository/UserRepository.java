package com.sample.splice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@EnableTransactionManagement
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<Customer> findAll() {
		
		return jdbcTemplate.query("select * from customer", new UserRowMapper());
	}

	
	public Customer findCustomerById(int id) {
		
		return jdbcTemplate.queryForObject("select * from customer where id=?", new Object[] { id },
				new UserRowMapper());
	}

	@Transactional
	public Customer createCustomer(Customer customer) {

		jdbcTemplate.update("INSERT INTO customer (id, name, email) values (?, ?, ?)", customer.getId(),
				customer.getName(), customer.getEmail());
		return customer;
	}

	@Transactional
	public String deleteCustomerById(int id) {

		jdbcTemplate.update("DELETE from customer WHERE id= ? ", id);
		return "Resource Deleted";
	}

	@Transactional
	public String updateCustomerEmailById(int id, String email) {
	
		jdbcTemplate.update("UPDATE customer SET email = ? WHERE id = ? ", email, id);
		return email;
	}
}

class UserRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {

		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setEmail(rs.getString("email"));
		return customer;
	}
}