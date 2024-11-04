package com.tartanga.grupo4.model;

import java.io.Serializable;

/**
 * The {@code User} class represents a system user and contains various attributes 
 * related to the user's personal and account information. 
 * <p>
 * The attributes include:
 * <ul>
 *   <li>{@code username}: The username of the user.</li>
 *   <li>{@code password}: The user's password.</li>
 *   <li>{@code name}: The full name of the user.</li>
 *   <li>{@code street}: The street address of the user.</li>
 *   <li>{@code active}: A {@code Boolean} value indicating if the user's account is active.</li>
 *   <li>{@code city}: The city where the user resides.</li>
 *   <li>{@code zip}: The zip code associated with the user's address.</li>
 * </ul>
 * This class implements the {@code Serializable} interface to allow instances 
 * to be serialized and transmitted across different contexts.
 * <p>
 * There are two constructors available:
 * <ul>
 *   <li>A parameterized constructor that initializes all the user attributes.</li>
 *   <li>An empty constructor that initializes all attributes to {@code null}.</li>
 * </ul>
 * Additionally, the class provides getter and setter methods for each attribute, 
 * along with a {@code toString} method that returns a string representation 
 * of the {@code User} object.
 * </p>
 * 
 * Example usage:
 * <pre>
 *     User user = new User("username123", "password456", "John Doe", 
 *                          "1234 Elm Street", true, "Springfield", 12345);
 *     System.out.println(user);
 * </pre>
 * 
 * @author egure
 */
public class User implements Serializable {

    /**
     * The user's unique username.
     */
    private String username;

    /**
     * The user's password, which should be kept secure.
     */
    private String password;

    /**
     * The full name of the user.
     */
    private String name;

    /**
     * The street address of the user.
     */
    private String street;

    /**
     * Indicates if the user's account is currently active.
     */
    private Boolean active;

    /**
     * The city where the user resides.
     */
    private String city;

    /**
     * The zip code for the user's address.
     */
    private Integer zip;

    /**
     * Constructs a {@code User} object with all specified attributes.
     * 
     * @param username The username of the user.
     * @param password The user's password.
     * @param name The full name of the user.
     * @param street The street address of the user.
     * @param active The active status of the user.
     * @param city The city where the user lives.
     * @param zip The zip code of the user's address.
     */
    public User(String username, String password, String name, String street, Boolean active, String city, Integer zip) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.street = street;
        this.active = active;
        this.city = city;
        this.zip = zip;
    }

    /**
     * Constructs a {@code User} object with all attributes initialized to {@code null}.
     */
    public User() {
        this.username = null;
        this.password = null;
        this.name = null;
        this.street = null;
        this.active = null;
        this.city = null;
        this.zip = null;
    }

    /**
     * Gets the username of the user.
     * 
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the full name of the user.
     * 
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the user.
     * 
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the street address of the user.
     * 
     * @return The street address of the user.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address of the user.
     * 
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the active status of the user.
     * 
     * @return The active status of the user.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active status of the user.
     * 
     * @param active The active status to set.
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Gets the city of the user.
     * 
     * @return The city of the user.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the user.
     * 
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the zip code of the user.
     * 
     * @return The zip code of the user.
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Sets the zip code of the user.
     * 
     * @param zip The zip code to set.
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Returns a string representation of the {@code User} object.
     * 
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" + 
               "username='" + username + '\'' + 
               ", password='" + password + '\'' + 
               ", name='" + name + '\'' + 
               ", street='" + street + '\'' + 
               ", active=" + active + 
               ", city='" + city + '\'' + 
               ", zip=" + zip + 
               '}';
    }
}
