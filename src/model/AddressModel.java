package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Address;

public class AddressModel {

	private static SessionFactory factory = BuildSessionFactory.build();

	public Address add(String city, int zipcode) {

		Session session = factory.openSession();
		Transaction transaction = null;
		Address address = null;

		try {
			transaction = session.beginTransaction();
			address = new Address(city, zipcode);
			session.save(address);
			transaction.commit();
		}
		catch (HibernateException e) {

			if (null != transaction) transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}

		return address;
	}

}
