package com.example.locationweb.controller;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;

import com.example.locationweb.entities.location;
import com.example.locationweb.repos.locationRepository;
import com.example.locationweb.service.locationService;
import com.example.locationweb.util.EmailUtil;
import com.example.locationweb.util.reportUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class locationController {

	@Autowired
	locationService service;
	@Autowired
	EmailUtil emailutil;
	@Autowired
	locationRepository repository;
	@Autowired
	reportUtil report;
	@Autowired
	ServletContext sc;
	
	@GetMapping("/")
	public String showCreate()
	{
		return "createLocation";
	}

	@RequestMapping(value ="/saveloc", method = RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location") location loc, Model model) throws MessagingException{
		location locationSaved = service.saveLocation(loc);
		String msg="Location saved within id: "+locationSaved.getId();
		model.addAttribute("succesMsg",msg);
		emailutil.sendEmail("Danijensen2324@gmail.com",
		 "Location it succesfully saved ",
		  "your location is succesfully saved and about to returned");
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(Model model)
	{
		List<location> locations = service.getAllLocations();
		model.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")  int id, Model model) {
		location loc=new location();
		loc.setId(id);
		service.deleteLocation(loc);

		List<location> locations = service.getAllLocations();
		model.addAttribute("locations", locations);

		return "displayLocations";
	}

	@RequestMapping("/editLocation")
	public String editLocation(@RequestParam("id") int id, Model model) {
		Optional<location> loc = service.getLocationbyId(id);
		model.addAttribute("loc", loc);
	

		return "editLocation";
	}

	@RequestMapping("/report")
	public String genereteReport(){
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		report.generatePieChart(path, data); 
		return"report";
	}

}
