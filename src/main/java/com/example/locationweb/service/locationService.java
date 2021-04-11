package com.example.locationweb.service;

import java.util.List;
import java.util.Optional;

import com.example.locationweb.entities.location;

public interface locationService {

	location saveLocation(location loc);

	location updateLocation(location loc);

	void deleteLocation(location loc);

	Optional<location> getLocationbyId(int id);

	List<location> getAllLocations();

}
