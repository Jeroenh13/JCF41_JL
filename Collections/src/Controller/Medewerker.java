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
public class Medewerker {
    
    private String naam;
    private int id;
    private Rol rol;
    
    Medewerker (String naam, int id, Rol rol)
    {
        this.naam = naam;
        this.id = id;
        this.rol = rol;
    }
    
}
