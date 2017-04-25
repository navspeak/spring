package com.nav.hsql;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/nav/hsql/beans.xml");
		
		OffersDAO offersDAO = (OffersDAO)context.getBean("OffersDAO");
		
		try {
			DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
			System.out.println(offersDAO.getOffer(1));
			Offer myoffer = new Offer(5, "Navneet1234", "ZZZZZZZZZZZZZ", "jkhl");
			System.out.println(offersDAO.update(myoffer));
			//System.out.println(offersDAO.create(myoffer));
			for (Offer offer : offersDAO.getOffers()) {
				System.out.println(offer);
			}
			System.out.println(offersDAO.getOffer(1));
			System.out.println(offersDAO.delete(1));
		} 
		catch(CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection.");
		}
		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		context.close();
	}

}
