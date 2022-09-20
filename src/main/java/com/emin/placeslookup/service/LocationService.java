package com.emin.placeslookup.service;

import com.emin.placeslookup.exception.LocationNotFoundException;
import com.emin.placeslookup.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    Location getLocation(double lat, double lng) throws LocationNotFoundException;
}
