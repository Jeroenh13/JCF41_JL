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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
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

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Heb je dan geen hoedje meer\n"
            + "Maak er één van bordpapier\n"
            + "Eén, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "En als het hoedje dan niet past\n"
            + "Zetten we 't in de glazenkas\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier";

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
        taOutput.setText(wordCounter(DEFAULT_TEXT));
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        taOutput.setText(backwardSort(DEFAULT_TEXT));
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        taOutput.setText(frequentie(DEFAULT_TEXT));
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        taOutput.setText(concordantie(DEFAULT_TEXT));

    }
    
    public String wordCounter(String story){
         //List sorteren en daarmee checken werkt het snelst. Bij een set haalt hij alle dubbele weg, en bij een map is een key niet echt van toepassing
        List<String> words = new ArrayList<>(Arrays.asList(story.split("\\W+")));
        TreeSet treeWords = new TreeSet<>(words);
        
        return "Aantal woorden: " + words.size() + "\n" + "Aantal verschillende woorden: " + treeWords.size();
    }
    
        public String backwardSort(String story)
    {
        //TreeSet vraagt snel de volgende in de reeks op.
        //Alle woorden met hoofdletter staan wel bovenaan gesorteerd..
        //Alle woorden naar kleine letters veranderd. Nu klopt het wel

        TreeSet<String> words = new TreeSet<>(Arrays.asList(story.toLowerCase().split("\\W+")));
        Iterator it = words.descendingIterator();
        StringBuilder sb = new StringBuilder();

        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }

        return sb.toString();
    }
    
    public String frequentie(String story)
    {
        List<String> words = new ArrayList<>(Arrays.asList(story.split("\\W+")));

        Map<String, Integer> wordsHashMap = new HashMap<>();

        //Elk woord dat nog niet is voorgekomen wordt erin gezet, woorden die al geweest zijn worden opgeteld.
        for (String s : words) {
            wordsHashMap.putIfAbsent(s, 0);
            int i = wordsHashMap.get(s) + 1;
            wordsHashMap.replace(s, i);
        }
        
        //Linked list voor snel benaderen van allles wat erin staat
        List sorted = new LinkedList(wordsHashMap.entrySet());
        // Comparator voor de value
        Collections.sort(sorted, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                 return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        //Alles van de gesorteerde hashmap wordt gezet in een linked hashmap zodat de ordening blijft zoals die was
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = sorted.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        
        Iterator it = sortedHashMap.entrySet().iterator();

        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }

        return sb.toString();
    }
            
    public String concordantie(String story)
    {
        List<String> lines = new ArrayList<>(Arrays.asList(story.toLowerCase().split("\\n+")));
        Map<Integer, String> linesHashMap = new HashMap<>();
        Map<String, String> wordsTreeMap = new TreeMap<>();
        Map<String, TreeSet> wordsTreeMap2 = new TreeMap<>();

        //Zet elke lijn in een hashmap
        int current = 1;
        for (String s : lines) {
            linesHashMap.put(current, s);
            current++;
        }
        
        //loopt door elke lijn heen
        for (Integer key : linesHashMap.keySet()) {
            List<String> words = new ArrayList<>(Arrays.asList(linesHashMap.get(key).split("\\W+")));
            for (String word : words) {
                if (wordsTreeMap.containsKey(word) || wordsTreeMap2.containsKey(word)) {
                    //haalt de treeset op, voegt een nieuwe waarde toe en zet hem er weer in
                    TreeSet temp = new TreeSet(wordsTreeMap2.get(word));
                    temp.add(key);
                    wordsTreeMap2.replace(word, temp);
                    
                    //Voegt de regel van de lijn toe
                    wordsTreeMap.replace(word, wordsTreeMap.get(word) + ", " + key.toString());
                } else {
                    //Maakt een nieuwe treeset als de key nog niet bestaat
                   TreeSet temp = new TreeSet();
                    temp.add(key);
                    wordsTreeMap2.putIfAbsent(word, temp);
                    
                    //maakt een nieuwe entry voor de string
                    wordsTreeMap.putIfAbsent(word, key.toString());
                }
            }
        }
        
        //iterator voor de string in de treemap
        Iterator it = wordsTreeMap.entrySet().iterator();

        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        
        //Iterator voor de treeset in de treemap
        Iterator it2 = wordsTreeMap2.entrySet().iterator();
        
        StringBuilder sb2 = new StringBuilder();
        while(it2.hasNext()){
            sb2.append(it2.next().toString()).append("\n");
        }

        return sb.toString();
    }
}
