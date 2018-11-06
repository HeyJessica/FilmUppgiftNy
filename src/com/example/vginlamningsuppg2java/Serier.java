package com.example.vginlamningsuppg2java;

import java.util.ArrayList;

/**
 * A class with functions about series
 *
 * @author  Jessica Gabrielsson
 * @version 1.0
 * @since   2018-10-31
 */

public class Serier {
    private ArrayList<Serie> mySeries;
    /**
     * The method creates a new array list
     */
    public Serier() {
        this.mySeries = new ArrayList<Serie>();
    }

    /**
     * The method checks if the serie to be added already exists, if not it is added to the array list
     * @param newSerie is a new serie created from class Serie
     * @return boolean that checks if the serie exists
     */
    public boolean addNewSerie(Serie newSerie) {
        if(findSerie(newSerie.getName()) >=0) {
            System.out.println("Serien är redan sparad.");
            return false;
        }

        mySeries.add(newSerie);
        return true;

    }
    /**
     * The method checks if the serie to be updated exists, if not it it added to the array list
     * @param oldSerie is the serie that exists
     * @param updatedSerie is the the new serie
     * @return boolean that checks if the serie exists or not
     */
    public boolean updateSerie(Serie oldSerie, Serie updatedSerie) {
        int foundPosition = findSerie(oldSerie);
        if(foundPosition <0) {
            System.out.println(oldSerie.getName() +", gick inte att hitta.");
            return false;
        }

        this.mySeries.set(foundPosition, updatedSerie);
        System.out.println(oldSerie.getName() + ", har uppdaterats med " + updatedSerie.getName());
        return true;
    }
    /**
     * The method removes a serie
     * @param serie is the serie to be removed, a variable created from the class Serie
     * @return boolean that checks if the serie exists or not
     */
    public boolean removeSerie(Serie serie) {
        int foundPosition = findSerie(serie);
        if(foundPosition <0) {
            System.out.println(serie.getName() +", gick inte att hitta.");
            return false;
        }
        this.mySeries.remove(foundPosition);
        System.out.println(serie.getName() + ", har tagits bort.");
        return true;
    }

    /**
     * The method loops through the array list to find the index of the serie
     * @param serie is the serie that we want to find
     * @return returns index of i or i-1.
     */
    private int findSerie(Serie serie) {
        return this.mySeries.indexOf(serie);
    }

    /**
     * The method loops through the array list to find the index of the serie
     * @param serieName is the the name of the serie that we search for
     * @return returns index of i or i-1.
     */
    private int findSerie(String serieName) {
        for(int i=0; i<this.mySeries.size(); i++) {
            Serie serie = this.mySeries.get(i);
            if(serie.getName().equals(serieName)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * The method uses the index from method findSerie,
     * if the serie has an index of 0 or higher, the position is returned.
     * Otherwise null is returned.
     * @param name is the name of the serie found in method findSerie
     * @return index of variable position, or null
     */
    public Serie querySerie(String name) { // ( returnerar Serie (ett objekt))
        int position = findSerie(name);
        if(position >=0) {
            return this.mySeries.get(position);
        }

        return null;
    }
    /**
     * The method prints out all series in the array list by looping through it
     */
    public void printSeries() {
        System.out.println("Serielista:");
        for(int i=0; i<this.mySeries.size(); i++) {
            String favorit = "";
            if(this.mySeries.get(i).getFavorite()){
               favorit= "*Serien är en favorit!*";
            }
            System.out.println((i+1) + ". Namn -> " +
                    this.mySeries.get(i).getName() + ". Årtal -> " +
                    this.mySeries.get(i).getYear() + ". Säsonger -> " +
                    this.mySeries.get(i).getEpisodes() + ". Episoder -> " +
                    this.mySeries.get(i).getSeasons() +". "+ favorit);

        }

    }


}
