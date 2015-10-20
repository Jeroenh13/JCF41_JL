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
    private int afdeling;
    
    Medewerker (int id, String naam, int afdeling)
    {
        this.naam = naam;
        this.id = id;
        this.afdeling = afdeling;
    }
    
}
