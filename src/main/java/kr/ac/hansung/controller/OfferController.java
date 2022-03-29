package kr.ac.hansung.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.ClassList;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller 
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		List<ClassList> offers=new ArrayList<ClassList>();
		int total = offerService.getAllGrade();
		
		offers.add(offerService.getGradeSum(2018, 1));
		offers.add(offerService.getGradeSum(2018, 2));
		offers.add(offerService.getGradeSum(2019, 1));
		offers.add(offerService.getGradeSum(2019, 2));
		offers.add(offerService.getGradeSum(2020, 1));
		offers.add(offerService.getGradeSum(2020, 2));
		
		model.addAttribute("offers", offers);
		model.addAttribute("total", total);
		
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffers(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
			if(result.hasErrors()) {
				List<ObjectError> errors= result.getAllErrors();
				
				for(ObjectError error: errors) {
					System.out.println(error.getDefaultMessage());
				}
				
				return "createoffer";
			}
		//System.out.println(offer); Controller -> Service -> Dao
		offerService.insert(offer);
		
		return "home";
	}
	
	@RequestMapping("/offercreated")
	public String offerCreated(Model model) {
		
		List<Offer> offers=offerService.getClass(2021, 1);
		model.addAttribute("offers", offers);
		
		return "offercreated";
		
	}
	
	@RequestMapping(value="/classes", method=RequestMethod.GET)
	public String ShowClass(@RequestParam("year")int year, @RequestParam("semester") int semester, Model model) {
		
		List<Offer> offers=offerService.getClass(year, semester);
		
		model.addAttribute("offers", offers);
		
		return "classes";
		
	}
}
