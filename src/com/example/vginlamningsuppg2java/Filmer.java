package com.example.vginlamningsuppg2java;

import java.util.ArrayList;

/**
 * A class with functions about movies
 *
 * @author  Jessica Gabrielsson
 * @version 1.0
 * @since   2018-10-31
 */

public class Filmer {

    private ArrayList<Film> myFilms;
    /**
     * The method creates a new array list
     */
    public Filmer(){
        this.myFilms = new ArrayList<Film>();
    }
    /**
     * The method checks if the movie to be added already exists, if not it is added to the array list
     * @param newFilm is a new movie, a variable created from the class Film
     * @return boolean that checks if the film exists
     */
    public boolean addNewFilm(Film newFilm) {
        if(findFilm(newFilm.getName()) >=0) {
            System.out.println("Filmen är redan sparad.");
            return false;
        }

        myFilms.add(newFilm);
        return true;

    }
    /**
     * The method checks if the movie to be updated exists
     * @param oldFilm is the movie that exists, a variable created from the class Film
     * @param uppdatedFilm is the the updated movie, a variable created from the class Film
     * @return boolean that checks if the film exists or not
     */
    public boolean updateFilm(Film oldFilm, Film uppdatedFilm) {
        int foundPosition = findFilm(oldFilm);
        if(foundPosition <0) {
            System.out.println(oldFilm.getName() +", gick inte att hitta.");
            return false;
        }

        this.myFilms.set(foundPosition, uppdatedFilm);
        return true;
    }

    /**
     * The method removes a movie
     * @param film is the movie to be removed, a variable created from the class Film
     * @return boolean that checks if the movie exists or not
     */
    public boolean removeFilm(Film film) {
        int foundPosition = findFilm(film);
        if(foundPosition <0) {
            System.out.println(film.getName() +", gick inte att hitta.");
            return false;
        }
        this.myFilms.remove(foundPosition);
        System.out.println(film.getName() + ", har tagits bort.");
        return true;
    }

    /**
     * The method loops through the array list to find the index of the movie based on the film name
     * @param film is the movie that we want to find
     * @return returns index of i or i-1.
     */
    private int findFilm(Film film) {
        return this.myFilms.indexOf(film);
    }

    /**
     * The method loops through the array list to find the index of the movie based on the film name
     * @param filmName is the the name of the movie that we search for
     * @return returns index of i or i-1.
     */
    private int findFilm(String filmName) {
        for(int i=0; i<this.myFilms.size(); i++) {
            Film film = this.myFilms.get(i);
            if(film.getName().equals(filmName)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * The method uses the index from method findFilm,
     * if the movie has an index of 0 or higher, the position is returned.
     * Otherwise null is returned.
     * @param name is the name of the movie found in method findFilm
     * @return index of variable position, or null
     */
    public Film queryFilm(String name) {
        int position = findFilm(name);
        if(position >=0) {
            return this.myFilms.get(position);
        }

        return null;
    }
    /**
     * The method prints out all movies in the array list by looping through it
     */
    public void printFilms() {
        System.out.println("Filmlista:");
        for(int i=0; i<this.myFilms.size(); i++) {
            String favorit = "";
            if(this.myFilms.get(i).getFavorite()){
                favorit = "*Filmen är en favorit!*";
            }
            System.out.println((i+1) + ". Namn -> " +
                    this.myFilms.get(i).getName() + ". Årtal -> " +
                    this.myFilms.get(i).getYear() + ". "+
                    favorit);
        }

    }
}
