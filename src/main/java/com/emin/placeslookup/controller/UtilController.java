package com.emin.placeslookup.controller;

import com.emin.placeslookup.model.Location;
import com.emin.placeslookup.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UtilController {

    private static final Logger logger = LoggerFactory.getLogger(UtilController.class);

    @Autowired
    LocationService locationService;

    @GetMapping("/all")
    public List<Location>getAllLocation() {
        return locationService.getAllLocations();
    }

    @GetMapping("/coordinates")
    public Location getLocationByCoordinates(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng) throws Exception {
        logger.debug("getLocationByCoordinates started.\nlatitude: {}\nlongitude: {}", lat, lng);
        return locationService.getLocation(lat, lng);
    }

}
