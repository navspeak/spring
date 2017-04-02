package com.nav.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.spring.web.dao.Offer;
import com.nav.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDAO;
	
	public List<Offer> getCurrent(){
		return offersDAO.getOffers();
	}
    
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDAO = offersDao;
	}

}
