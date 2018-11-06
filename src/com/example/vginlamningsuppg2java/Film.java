package com.example.vginlamningsuppg2java;

/**
 * A super class with a constructor for movies
 *
 * @author  Jessica Gabrielsson
 * @version 1.0
 * @since   2018-10-31
 */

public class Film {
    private String name;
    private String year;
    private boolean isFavorite;

    /**
     * Constructor for super class
     */
    public Film(String name, String year, boolean isFavorite){
        this.name = name;
        this.year = year;
        this.isFavorite = isFavorite;
    }
    /**
     * The method gets name, year and favorite
     * @return name, year and favorite
     */
    public String getName(){ return name; }
    public String getYear(){ return year; }
    public boolean getFavorite(){ return isFavorite; }
}
