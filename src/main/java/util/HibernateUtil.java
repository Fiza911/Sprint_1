package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Admin;
import com.demo.entity.Customer;
import com.demo.entity.Feedback;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import com.demo.entity.RestaurantTable;

public class HibernateUtil 
{
	private final static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()
	{
		try {
			return new Configuration().configure("Hibernate.cfg.xml")
					.addAnnotatedClass(Restaurant.class)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Reservation.class)
					.addAnnotatedClass(Feedback.class)
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(RestaurantTable.class)
					.buildSessionFactory();			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}
}
