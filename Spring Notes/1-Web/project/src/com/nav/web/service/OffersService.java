package com.nav.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.web.dao.Offer;
import com.nav.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	@Autowired //@Resource(name="offersDAO")
	private OffersDAO offersDAO;
	
	public List<Offer> getCurrentOffers(){
		return offersDAO.getOffers();
	}

}
