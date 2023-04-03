package connector;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("B3L5");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed."+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
