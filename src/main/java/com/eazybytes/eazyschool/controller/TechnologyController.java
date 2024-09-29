package com.eazybytes.eazyschool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eazybytes.eazyschool.model.Technology;
import com.eazybytes.eazyschool.service.TechnologyService;

@Controller
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@GetMapping("technology")
	public String technology(Model model) {
		List<Technology> technologyList =technologyService.findAllTechnology();
		model.addAttribute("technologyList",technologyList);
		model.addAttribute("technology", new Technology());
		return "technology";
	}
	
	@PostMapping("saveTechnology")
	public String saveTechnology(@Valid @ModelAttribute("technology") Technology technology, BindingResult bResult,
			Model model) {
		
		List<Technology> technologyList =technologyService.findAllTechnology();
		
		
		if (bResult.hasErrors()) {
			model.addAttribute("technologyList",technologyList);
			return "technology";
		}
		else {
			technologyService.saveTechnology(technology);
			return "redirect:/technology";
		}
		
	}
	
	@GetMapping("updateTechnology")
	public String updateTechnology(@ModelAttribute("id") Long id, Model model) {
		Technology technology=technologyService.getTechnologyFromId(id);
		List<Technology> technologyList =technologyService.findAllTechnology();

		model.addAttribute("technologyList",technologyList);

		model.addAttribute("technology",technology);
		return "technology";
	}
	
	@GetMapping("daleteTechnology")
	public String daleteTechnology(@ModelAttribute("id") Long id, Model model) {
		this.technologyService.daleteTechnology(id);
		
		return "redirect:technology";
	}

}
