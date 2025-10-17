package com.example.listycity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(mockCity());
        return list;
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

        assertThrows(Exception.class, () -> cityList.add(city));
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

    // ----- New tests required by the exercise -----

    @Test
    public void testHasCityTrueFalse() {
        CityList list = mockCityList();
        City edm = mockCity();
        City cal = new City("Calgary", "Alberta");

        assertTrue(list.hasCity(edm));
        assertFalse(list.hasCity(cal));
    }

    @Test
    public void testDeleteRemoves() {
        CityList list = mockCityList();
        City edm = mockCity();

        assertTrue(list.hasCity(edm));
        try {
            list.delete(edm);
        } catch (Exception e) {
            System.out.println("err: " + e);
        }

        assertFalse(list.hasCity(edm));
        assertEquals(0, list.countCities());
    }

    @Test
    public void testDeleteThrowsWhenMissing() {
        CityList list = mockCityList();
        City missing = new City("Regina", "Saskatchewan");

        Exception exception = assertThrows(Exception.class, () -> list.delete(missing));
        assertEquals("City not present: Regina", exception.getMessage());

    }

    @Test
    public void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());

        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, list.countCities());
    }
}
