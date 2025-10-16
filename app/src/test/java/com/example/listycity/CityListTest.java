package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * Unit tests for {@link CityList}.
 */
public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList list = new CityList();
        City a = new City("Edmonton", "Alberta");
        City b = new City("Calgary", "Alberta");
        list.add(a);
        assertTrue(list.hasCity(a));
        assertFalse(list.hasCity(b));
    }

    @Test
    public void testDeleteSuccess() {
        CityList list = new CityList();
        City a = new City("Edmonton", "Alberta");
        list.add(a);
        list.delete(a);
        assertFalse(list.hasCity(a));
        assertEquals(0, list.countCities());
    }

    @Test
    public void testDeleteThrows() {
        CityList list = new CityList();
        City a = new City("Edmonton", "Alberta");
        City b = new City("Calgary", "Alberta");
        list.add(a);
        assertThrows(IllegalArgumentException.class, () -> list.delete(b));
    }

    @Test
    public void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
        list.delete(new City("Edmonton", "Alberta"));
        assertEquals(1, list.countCities());
    }
}
