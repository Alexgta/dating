package com.job4j.dating.controller;

import com.job4j.dating.entity.Ad;
import com.job4j.dating.entity.dict.MaritalStatus;
import com.job4j.dating.service.AdService;
import com.job4j.dating.service.MaritalStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/my_ad")
public class AdController {

	private final AdService theAdService;
	private final MaritalStatusService theMaritalStatusService;

	public AdController(AdService theAdService, MaritalStatusService theMaritalStatusService) {
		this.theAdService = theAdService;
		this.theMaritalStatusService = theMaritalStatusService;
	}

	// add mapping for "/show"
	@GetMapping("/show")
	public String listAds(Model theModel) {
		
		// get Ads from db
		List<Ad> theAds = theAdService.findAll();
		
		// add to the spring model
		theModel.addAttribute("ads", theAds);
		
		return "ru/list-ad";
	}
	
	@GetMapping("/showFormAd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Ad theAd = new Ad();
		MaritalStatus theMaritalStatus = new MaritalStatus();
		
		theModel.addAttribute("ad", theAd);
		theModel.addAttribute("maritalStatus", theMaritalStatus);
		
		return "ru/ad-form";
	}

	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the Ad from the service
		Ad theAd = theAdService.findById(theId);
		List<MaritalStatus> theMaritalStatuses = theMaritalStatusService.findCurrent(theAd.getLanguage(), theAd.getGender());
		//List<MaritalStatus> theMaritalStatuses = theAd.getMaritalStatusList();

		// set Ad as a model attribute to pre-populate the form
		theModel.addAttribute("ad", theAd);
		theModel.addAttribute("maritalStatuses", theMaritalStatuses);
		
		// send over to our form
		return "ru/ad-form";
	}
	
	
	@PostMapping("/save")
	public String saveAd(@ModelAttribute("ad") Ad pAd) {
		
		// save the ad
		theAdService.save(pAd);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/my_ad/show";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("adId") int theId) {
		
		// delete the Ad
		theAdService.deleteById(theId);
		
		// redirect to /carsjpa/list
		return "redirect:/my_ad/show";
		
	}
}


