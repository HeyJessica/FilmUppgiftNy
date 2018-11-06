package com.example.vginlamningsuppg2java;

/**
 * A sub class with a constructor for series
 *
 * @author  Jessica Gabrielsson
 * @version 1.0
 * @since   2018-10-31
 */

public class Serie extends Film{
    //privata instansvariabler för subklassen
    private String episodes;
    private String seasons;

    /**
     * Constructor for sub class
     */
    public Serie(String name, String year, boolean isFavorite, String episodes, String seasons){
        super(name, year, isFavorite);
        this.episodes = episodes;
        this.seasons = seasons;
    }
    /**
     * The method gets episodes and seasons
     * @return episodes and seasons
     */
    public String getEpisodes() { return episodes; }
    public String getSeasons() { return seasons; }
}
