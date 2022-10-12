package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

		//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		 //get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer"
				+ " order by lastName",Customer.class);
		//execute query and  get result
		
		List<Customer> customers = theQuery.getResultList();
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		 //get the current hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		//save or update the customer 
		currentSession.saveOrUpdate(theCustomer);

		
	}

	@Override
	public Customer getCustomer(int theID) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		
		
	    Customer customer = currentSession.get(Customer.class, theID);
		//return the results
		return customer;
	}

}
