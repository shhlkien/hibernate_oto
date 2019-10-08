package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BuildSessionFactory {

	public static SessionFactory factory = null;

	public static SessionFactory build() {

		if (null == factory) {

			try {
				factory = new Configuration().configure().buildSessionFactory();
			}
			catch (Throwable e) {
				throw new ExceptionInInitializerError(e);
			}
		}

		return factory;
	}
}
