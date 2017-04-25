package com.navn.test.hsql;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Before;
import org.junit.Test;

import com.nav.hsql.RepositoryConfig;
import com.nav.spring.mysql.Offer;
import com.nav.spring.mysql.OffersDAO;


public class RepositoryConfigTest {
	
	private DataSource db;

	@Before
	public void test() {
		RepositoryConfig config = new RepositoryConfig();
		this.db = config.datasource();
	}
	
	@Test
	public void testFindByName(){
		//DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
    	OffersDAO offersDAO = new OffersDAO();
    	offersDAO.setDataSource(db);
    	Offer offer = null;
    	try {
    	 offer = offersDAO.getOffer(1);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	System.out.println(offer);
    	assertNotNull(offer);
	}

}
