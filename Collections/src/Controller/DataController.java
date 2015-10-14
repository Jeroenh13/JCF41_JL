/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Jeroen Hendriks
 */
public class DataController {
    
    private TreeMap<Afdeling, Rol> afdelingMap;
    private HashMap<Medewerker, Rol> medewerkerMap;
    
    DataController()
    {
        afdelingMap = new TreeMap();
        medewerkerMap = new HashMap();
    }
    
    public void vulTestdata()
    {
        //Afdelingen
        Afdeling a = new Afdeling("FHICT", 1);
            Afdeling b = new Afdeling("Directie", 2, a);
            Afdeling c = new Afdeling("ISSD", 3, a);
            Afdeling d = new Afdeling("Onderwijs", 4, a);
                Afdeling e = new Afdeling("Profiel", 5, d);
                    Afdeling f = new Afdeling("Team S", 6, e);
                    Afdeling g = new Afdeling("Team T", 7, e);
                    Afdeling h = new Afdeling("Team B", 8, e);
                    Afdeling i = new Afdeling("Team M", 9, e);
                Afdeling j = new Afdeling("Innovatie", 10, d);
                    Afdeling k = new Afdeling("ICS", 11, j);
                    Afdeling l = new Afdeling("IMS", 12, j);
                    Afdeling m = new Afdeling("SM", 13, j);
                    Afdeling n = new Afdeling("EDU", 14, j);
                    Afdeling o = new Afdeling("GD", 15, j);
                    Afdeling p = new Afdeling("DP", 16, j);
                    Afdeling q = new Afdeling("LS", 17, j);
                    
        //Rollen
                   
      
    }
    
}
