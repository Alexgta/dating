package com.job4j.dating.controller;

import com.job4j.dating.entity.Ad;
import com.job4j.dating.entity.dict.MaritalStatus;
import com.job4j.dating.entity.dict.MaxCity;
import com.job4j.dating.entity.dict.MaxCityName;
import com.job4j.dating.entity.dict.MaxCountry;
import com.job4j.dating.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/my_ad")
public class AdController {

	private final AdService theAdService;
	private final MaxCityService theMaxCityService;
	private final MaxCityNameService theMaxCityNameService;
	private final MaxCountryService theMaxCountryService;
	private final MaritalStatusService theMaritalStatusService;

	public AdController(AdService theAdService,
						MaxCityService theMaxCityService,
						MaxCityNameService theMaxCityNameService,
						MaxCountryService theMaxCountryService,
						MaritalStatusService theMaritalStatusService) {
		this.theAdService = theAdService;
		this.theMaxCityService = theMaxCityService;
		this.theMaxCityNameService = theMaxCityNameService;
		this.theMaxCountryService = theMaxCountryService;
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
		MaxCity theMaxCity = theMaxCityService.findById(theAd.getCityId());
		List<MaxCity> maxCityList = theMaxCityService.findAll();
		List<MaxCountry> theMaxCountryList = theMaxCountryService.findRegionCountries(theAd.getLanguage());

		theModel.addAttribute("ad", theAd);
		theModel.addAttribute("maritalStatus", theMaritalStatus);
		theModel.addAttribute("maxCity", theMaxCity);
		theModel.addAttribute("maxCityList", maxCityList);
		theModel.addAttribute("maxCountryList", theMaxCountryList);

		return "ru/ad-form";
	}


	@PostMapping("/selectCities")
	public String showSelectCities(@RequestParam("customerId") int theId,
									@RequestPart("countryId") String countryId,
									@RequestParam("cityNameStart") String cityNameStart,
									Model theModel) {

		// get the Ad from the service
		Ad theAd = theAdService.findById(theId);
		List<MaritalStatus> theMaritalStatusList = theMaritalStatusService.findCurrent(theAd.getLanguage(), theAd.getGender());
		//MaxCity theMaxCity = theMaxCityService.findById(theAd.getCityId());
		//List<MaxCity> maxCityList = theMaxCityService.findByCountryId(countryId);

		String pCityNameStart = cityNameStart + "%";
		List<MaxCityName> maxCityNameList = theMaxCityNameService.findByCityNameStart(countryId, pCityNameStart, theAd.getLanguage());
		List<MaxCountry> theMaxCountryList = theMaxCountryService.findRegionCountries(theAd.getLanguage());

		// set Ad as a model attribute to pre-populate the form
		theModel.addAttribute("ad", theAd);
		//theModel.addAttribute("maxCity", theMaxCity);
		//theModel.addAttribute("maxCityList", maxCityList);
		theModel.addAttribute("maxCityNameList", maxCityNameList);
		theModel.addAttribute("cityNameStart", cityNameStart);
		theModel.addAttribute("maxCountryList", theMaxCountryList);
		theModel.addAttribute("maritalStatusList", theMaritalStatusList);


		// send over to our form
		return "ru/ad-form";
	}


	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the Ad from the service
		Ad theAd = theAdService.findById(theId);
		List<MaritalStatus> theMaritalStatusList = theMaritalStatusService.findCurrent(theAd.getLanguage(), theAd.getGender());
		//MaxCity theMaxCity = theMaxCityService.findById(theAd.getCityId());
		//List<MaxCity> maxCityList = theMaxCityService.findAll();
		List<MaxCity> maxCityNameList = new ArrayList<>();
		List<MaxCountry> theMaxCountryList = theMaxCountryService.findRegionCountries(theAd.getLanguage());

		// set Ad as a model attribute to pre-populate the form
		theModel.addAttribute("ad", theAd);
		//theModel.addAttribute("maxCity", theMaxCity);
		//theModel.addAttribute("maxCityList", maxCityList);
		theModel.addAttribute("maxCityNameList", maxCityNameList);
		theModel.addAttribute("maxCountryList", theMaxCountryList);
		theModel.addAttribute("maritalStatusList", theMaritalStatusList);


		// send over to our form
		return "ru/ad-form";
	}
	
	
	@PostMapping("/save")
	public String saveAd(@ModelAttribute("ad") Ad pAd,
						 @RequestParam("birthdateDay") int birthdateDay,
						 @RequestParam("birthdateMonth") int birthdateMonth,
						 @RequestParam("birthdateYear") int birthdateYear) {
		System.out.println("birthdateDay" + birthdateDay);
		Calendar calendar = Calendar.getInstance();
		Date dateOfBirth;
		try {
			calendar.set(birthdateYear, birthdateMonth, birthdateDay);
			dateOfBirth = calendar.getTime();
		} catch (Exception e) {
			Ad oldAd = theAdService.findById(pAd.getCustomerId());
			dateOfBirth = oldAd.getDateOfBirth();
		}

		pAd.setDateOfBirth(dateOfBirth);
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


