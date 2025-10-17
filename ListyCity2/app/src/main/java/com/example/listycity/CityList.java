package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Returns whether the given city is present in the list.
     *
     * @param city the city to check (non-null)
     * @return true if present; false otherwise
     * @throws NullPointerException if {@code city} is null
     */
    public boolean hasCity(City city) {
        Objects.requireNonNull(city, "city");
        for (City c : cities) {
            if (sameCity(c, city)) return true;
        }
        return false;
    }

    private static boolean sameCity(City a, City b) {
        return a.getCityName().equals(b.getCityName())
                && a.getProvinceName().equals(b.getProvinceName());
    }

    /**
     * Deletes the given city from the list if present; otherwise throws exceptions.
     *
     * @param city the city to remove (non-null)
     * @throws NullPointerException      if {@code city} is null
     * @throws IllegalArgumentException  if the city is not in the list
     */
    public void delete(City city) {
        Objects.requireNonNull(city, "city");
        for (int i = 0; i < cities.size(); i++) {
            if (sameCity(cities.get(i), city)) {
                cities.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("City not found: "
                + city.getCityName() + ", " + city.getProvinceName());
    }


}
