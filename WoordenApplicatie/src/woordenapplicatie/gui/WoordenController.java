package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        //List sorteren en daarmee checken werkt het snelst. Bij een set haalt hij alle dubbele weg, en bij een map is een key niet echt van toepassing
        List<String> words = new ArrayList<>(Arrays.asList(DEFAULT_TEXT.split("\\W+")));
        Collections.sort(words);
        
        int cnt = 0;
        String tmp = "";
        for(String s : words)
        {
            if(!tmp.toUpperCase().equals(s.toUpperCase()))
            {
                tmp = s;
                cnt++;
            }
        }
        taOutput.setText("Aantal woorden: " + words.size() + "\n" + "Aantal verschillende woorden: " + cnt); 
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        //TreeSet vraagt snel de volgende in de reeks op.
        //Alle woorden met hoofdletter staan wel bovenaan gesorteerd..
        TreeSet<String> words = new TreeSet<>(Arrays.asList(DEFAULT_TEXT.split("\\W+")));
        
        Iterator it = words.descendingIterator();
        StringBuilder sb = new StringBuilder();
         
        while(it.hasNext())
        {
            sb.append(it.next()).append("\n");
        }
        
        taOutput.setText(sb.toString()); 
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}
