package com.emin.placeslookup.service.implementation;

import com.emin.placeslookup.exception.LocationNotFoundException;
import com.emin.placeslookup.model.Location;
import com.emin.placeslookup.repository.LocationRepository;
import com.emin.placeslookup.service.LocationService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(double lat, double lng) throws LocationNotFoundException {
        Optional<Location> locationOptional = locationRepository.findByLatitudeAndLongitude(lat, lng);
        Location location;
        if(locationOptional.isPresent())
        {
            location = locationOptional.get();
        } else {
            logger.error("Location not found for: lat = {}, long = {}", lat, lng);
            throw new LocationNotFoundException();
        }
        return location;
    }
}

