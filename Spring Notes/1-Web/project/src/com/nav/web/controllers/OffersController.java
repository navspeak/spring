package com.nav.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nav.web.dao.Offer;
import com.nav.web.service.OffersService;

@Controller
public class OffersController {
	
//	@RequestMapping("/")
//	public String showHome(HttpSession session){
//		session.setAttribute("name", "Navneet");
//		return "home";
//	}
//	
//	@RequestMapping("/")
//	public ModelAndView showHome(){
//		ModelAndView mv = new ModelAndView("home");
//		ModelMap map = mv.getModelMap();
//		map.addAttribute("name", "River");
//		return mv;
//	}

	
	@Autowired
	private OffersService offersService;
	
	
	@RequestMapping("/")
	public String showHome(Model model){
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
		List<Offer> offers = offersService.getCurrentOffers();
		model.addAttribute("offers", offers);
		return "home";
	}	
}
