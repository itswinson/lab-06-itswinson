package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 * It provides functionality to add cities, check membership, delete, count, and retrieve a sorted list.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     * @param city the city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of cities by their names.
     * @return a list of cities in ascending order of city names
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Returns whether the given city exists in the list.
     * @param city the city to check
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the given city if present; otherwise throws.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns how many cities are currently in the list.
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
