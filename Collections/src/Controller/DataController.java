/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.collections.ObservableList;

/**
 *
 * @author Jeroen Hendriks
 */
public class DataController {

    private TreeSet<Afdeling> afdelingen;
    private HashSet<Medewerker> medewerkers;

    public DataController() {
        afdelingen = new TreeSet();
        medewerkers = new HashSet();
        vulTestdata();
    }

    public ObservableList<Afdeling> getAfdelingen() {

        return (ObservableList<Afdeling>) afdelingen;
    }

    public void vulTestdata() {
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

        //Medewerker
        Medewerker ma = new Medewerker(1, "Lisa van Kessel", 2);
        Medewerker mb = new Medewerker(2, "Jeroen Hendriks", 3);
        Medewerker mc = new Medewerker(3, "Jurgen van den Berg", 3);
        Medewerker md = new Medewerker(4, "Thom Bijsterbosch", 6);
        Medewerker me = new Medewerker(5, "Kevin Grond", 6);
        Medewerker mf = new Medewerker(6, "Tijn Renders", 7);
        Medewerker mg = new Medewerker(7, "Eric van Aert", 8);
        Medewerker mh = new Medewerker(8, "Lars Jaeqx", 11);
        Medewerker mi = new Medewerker(9, "Wouter Habets", 12);
        Medewerker mj = new Medewerker(10, "Diane Melaan", 14);
        Medewerker mk = new Medewerker(11, "Konghon Choo", 15);

        afdelingen.addAll( Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q));
        medewerkers.addAll( Arrays.asList(ma, mb, mc, md, me, mf, mg, mh, mi, mj, mk));

    }

}
