/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;

/**
 *
 * @author lisavankessel
 */
public class Afdeling implements Serializable, Comparable<Afdeling> {
    
    private String naam;
    private int id;
    private String parentid;
        
    Afdeling (String naam, int id, String parentAfdeling)
    {
        this.naam = naam;
        this.id = id;
        this.parentid = parentAfdeling;
    }
    
    public String getNaam()
    {
        return naam;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getParentID()
    {
        return parentid;
    }
    
    public void setNaam(String naam)
    {
        this.naam = naam;
    }

    @Override
    public int compareTo(Afdeling other) {
        return 1;
    }
}
