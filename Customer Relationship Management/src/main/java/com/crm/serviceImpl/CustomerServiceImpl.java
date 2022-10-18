package com.crm.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.model.Customer;
import com.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	@Override
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}

	@Transactional
	@Override
	public Customer findById(long id) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Transactional
	@Override
	public void save(Customer theCustomer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		tx.commit();
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tx.commit();
	}
}
