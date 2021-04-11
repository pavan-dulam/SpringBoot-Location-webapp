package com.example.locationweb.controller;

import java.util.List;
import java.util.Optional;



import com.example.locationweb.entities.location;
import com.example.locationweb.repos.locationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class locationRESTController {
   @Autowired
    locationRepository repository;
private Optional<location> findById;

    @GetMapping
    public List<location> getLocations(){
        return repository.findAll();
    }

    @PostMapping
    public location createLocation( @RequestBody location loc){
        return repository.save(loc);
    }

    @PutMapping
    public location updateLocation(@RequestBody location loc) {
        return repository.save(loc);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<location> getLocation(@PathVariable("id") int id) {
        findById = repository.findById(id);
        return findById;
    }
}
