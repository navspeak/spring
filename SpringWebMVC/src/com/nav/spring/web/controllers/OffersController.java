package com.nav.spring.web.controllers;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		//offersService.throwTestException();
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		//model.addAttribute("name", "<b>Navneet2</b>");
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffers(Model model){
		// this name must match the commandName (name of the attribute in the mode)
		// in createoffer.jsp view
		model.addAttribute("offer", new Offer()); 
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result){
		
		if(result.hasErrors()){
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError err: errors){
				System.out.println(err.getDefaultMessage());
			}
			return "createoffer";
		}

		offersService.create(offer);
		return "offercreated";
	}
	
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseException(DataAccessException ex){
//		return "error";
//	}
	
}
