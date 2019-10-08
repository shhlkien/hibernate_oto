package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Address;
import entity.User;

public class UserModel {

	private static SessionFactory factory = BuildSessionFactory.build();

	public int add(String name, Address address) {

		int id = 0;
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			id = (int) session.save(new User(name, address));
			transaction.commit();
		}
		catch (HibernateException e) {

			if (null != transaction) transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		return id;
	}

	public void update(int id, Address address) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			User user = session.get(User.class, id);
			user.setAddress(address);
			session.update(user);
			transaction.commit();
		}
		catch (HibernateException e) {

			if (null != transaction) transaction.commit();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public void delete(int id) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(session.get(User.class, id));
			transaction.commit();
		}
		catch (HibernateException e) {

			if (null != transaction) transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public List<?> list() {

		Session session = factory.openSession();
		Transaction transaction = null;
		List<?> users = null;

		try {
			transaction = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			transaction.commit();
		}
		catch (HibernateException e) {

			if (null != transaction) transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		return users;
	}
}
