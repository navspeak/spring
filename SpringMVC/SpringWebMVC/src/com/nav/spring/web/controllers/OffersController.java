package com.nav.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nav.spring.web.dao.Offer;
import com.nav.spring.web.service.OffersService;

@Controller
public class OffersController {

//	@RequestMapping("/")
//	public String showHome(HttpSession session){
//		session.setAttribute("name", "Navneet");
//		return "home";
//	}
	

//	@RequestMapping("/")
//	public ModelAndView showHome(HttpSession session){
//		ModelAndView mv = new ModelAndView("home");
//		Map<String, Object> map = mv.getModel();
//		map.put("name","Navneet1");
//		return mv;
//	}
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id){
		System.out.println("Id is :" + id);
		return "home";
	}

	@RequestMapping("/offers")
	public String showOffers(Model model){
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		//model.addAttribute("name", "<b>Navneet2</b>");
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffers(Model model){
		return "createoffer";
	}
	
	
}
