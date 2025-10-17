package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a collection of City objects with basic operations.
 */
public class CityList {

    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist.
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city.getCityName());
        }
        cities.add(city);
    }

    /** Returns a sorted copy of all cities. */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /** Returns whether the given city exists in the list. */
    public boolean hasCity(City city) {
        for (City c : cities) {
        if (c.compareTo(city) == 0) {
            return true;
        }
    }
        return false;
    }

    /**
     * Removes the given city from the list.
     * @throws IllegalArgumentException if the city is not present
     */
    public void delete(City city) throws Exception {
        if (!hasCity(city)){
            throw new Exception("City not present: " + city.getCityName());
        }
        for (City c : cities) {
            if (c.compareTo(city) == 0) {
                cities.remove(c);
            }
        }
    }
    /** Returns how many cities are currently stored. */
    public int countCities() {
        return cities.size();
    }
}
