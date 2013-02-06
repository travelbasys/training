package de.travelbasys.training.dao;

import java.io.IOException;
import java.util.List;

import de.travelbasys.training.business.Customer;

public interface CustomerDAO {
	public void init(String db);

	void CloseCurrentConnection();

	public void terminate();

	public List<Customer> findAll();

	public void create(Customer customer) throws CustomerDaoException;

	int createNewId();

	public Customer findById(int id);

	public void update(Customer customer) throws CustomerDaoException;

	public void delete(Customer customer);

	void OpenConnection();

	public Customer getExisting(Customer customer) throws CustomerDaoException;

	public void importCSV(String name) throws IOException, CustomerDaoException;

}
