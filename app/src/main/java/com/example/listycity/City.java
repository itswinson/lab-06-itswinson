package com.example.listycity;

/**
 * Represents a city object containing its name and province.
 * Implements {@link Comparable} to allow sorting by city name.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Creates a city object with its name and province.
     * @param city the city name
     * @param province the province name
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of this city.
     * @return the city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * Returns the province of this city.
     * @return the province name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Compares this city to another city lexicographically by name.
     * @param city another city to compare to
     * @return a negative integer, zero, or a positive integer if this city name
     *         is less than, equal to, or greater than the specified city name
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Determines whether two city objects are equal.
     * Two cities are considered equal if they have the same name and province.
     * @param o the object to compare
     * @return true if the cities have the same name and province, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City cityObj = (City) o;
        return this.city.equals(cityObj.getCityName())
                && this.province.equals(cityObj.getProvinceName());
    }

    /**
     * Returns a hash code value for this city.
     * @return the hash code of the city
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}
