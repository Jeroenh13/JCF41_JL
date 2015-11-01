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
public class Medewerker implements Serializable {
    
    private String naam;
    private int id;
    private String afdeling;
    
    Medewerker (int id, String naam, String afdeling)
    {
        this.naam = naam;
        this.id = id;
        this.afdeling = afdeling;
    }
    
    public String getNaam()
    {
        return naam;
    }
    
    public void setNaam(String naam)
    {
        this.naam = naam;
    }
    
    public String getAfdeling()
    {
        return afdeling;
    }
    
    public void setAfdeling(String naam)
    {
        afdeling = naam;
    }
}
