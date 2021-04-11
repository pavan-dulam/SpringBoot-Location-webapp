package com.example.locationweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationweb.entities.location;
import com.example.locationweb.repos.locationRepository;

@Service
public class locationServiceImpl implements locationService {

	@Autowired
	private locationRepository repository;

	@Override
	public location saveLocation(location loc) {
		return repository.save(loc);
	}

	@Override
	public location updateLocation(location loc) {
		return repository.save(loc);
	}

	@Override
	public void deleteLocation(location loc) {
		repository.delete(loc);

	}

	@Override
	public Optional<location> getLocationbyId(int id) {
		return repository.findById(id);
	}

	@Override
	public List<location> getAllLocations() {
		return repository.findAll();
	}

	public locationRepository getRepository() {
		return repository;
	}

	public void setRepository(locationRepository repository) {
		this.repository = repository;
	}

}
