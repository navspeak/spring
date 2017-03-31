package com.nav.spring.B;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/nav/spring/beans/beans2.xml");

		OffersDAO offersDAO = (OffersDAO)context.getBean("offersDAO");

		try {
//			int delRows = offersDAO.deleteAll();
//			if (delRows > 0) {
//				System.out.println("Deleted rows " + delRows);
//				
//			}
			
			List<Offer> offersList = new ArrayList<Offer>();
			offersList.add(new Offer(1, "Navneet", "Nav@xyz.com", "Code monkey"));
			offersList.add(new Offer(13, "Navneet1", "Nav1@xyz.com", "Code Donkey"));
			
			int[] retVals = offersDAO.create(offersList);
			for(int val : retVals){
				System.out.println("Updated " + val + "rows.");
			}
			
			List<Offer> offers = offersDAO.getOffers();
			
			for (Offer offer : offers)
				System.out.println(offer);
			
			//System.out.println(offersDAO.getOffer(1));
			


			
//			if (offersDAO.create(offer1))
//				System.out.println("Offer1 created");
//			if (offersDAO.create(offer2))
//				System.out.println("Offer2 created");
			
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}


		((ClassPathXmlApplicationContext)context).close();
	}

}
