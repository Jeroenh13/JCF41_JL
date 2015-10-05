/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanopdracht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Lisa
 */
public class HuffmanController {
    
    public HuffmanController(){};
           

    private static final String DEFAULT_TEXT = 
             "liesje leerde lotje lopen langs de lange lindelaan";
    
    private List<Node> HuffmanTree = new ArrayList<Node>();
    
    public String internGetFrequentie()
    {
        List<Node> nodes = getFrequencyTree(DEFAULT_TEXT);
        List<Node> sortedNodes = sortHuffman(nodes);
        return "";
        //return getFrequentie(DEFAULT_TEXT);
    }

    private List<Node> sortHuffman(List<Node> us)
    {
        Collections.sort(us, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                 return (
                         ((Node) (o2)).compareTo((Node) (o1)));
            }
        });
        return us; 
    }
    
    private List<Node> getFrequencyTree(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> freqList = new LinkedHashMap<>();
        List<Node> HuffTree = new ArrayList<>();
        
        for (char key : charArray) {
            if (freqList.containsKey(key)) {
                freqList.put(key, freqList.get(key) + 1);
            } else {
                freqList.put(key, 1);
            }
        }
                Iterator it = freqList.entrySet().iterator();
        while (it.hasNext())
        {
            Entry e = (Entry) it.next();
            HuffTree.add(new Node((char)e.getKey(),(Integer)e.getValue()));
        }
        return HuffTree;
    }
}
