/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author lisavankessel
 */
public class Afdeling {
    
    private String naam;
    private int id;
    private Afdeling parentAfdeling;
    
    Afdeling (String naam, int id)
    {
        this.naam = naam;
        this.id = id;
    }
    
    Afdeling (String naam, int id, Afdeling parentAfdeling)
    {
        this.naam = naam;
        this.id = id;
        this.parentAfdeling = parentAfdeling;
    }
    
}
