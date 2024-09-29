package com.eazybytes.eazyschool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazybytes.eazyschool.model.Technology;
import com.eazybytes.eazyschool.repository.TechnologyRepository;

@Service
public class TechnologyService {
	
	@Autowired
	private TechnologyRepository technologyRepository;

	public List<Technology> findAllTechnology() {
		return technologyRepository.findAll();
	}

	public void saveTechnology(@Valid Technology technology) {
		technologyRepository.save(technology);
	}

	public Technology getTechnologyFromId(Long id) {
		return technologyRepository.findById(id).get();
	}

	public void daleteTechnology(Long id) {
		technologyRepository.delete(getTechnologyFromId(id));
	}

}
