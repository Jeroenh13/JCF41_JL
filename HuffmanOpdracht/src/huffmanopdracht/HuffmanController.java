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
        List<Node> hoi = getFrequencyTree(DEFAULT_TEXT);
        return "";
        //return getFrequentie(DEFAULT_TEXT);
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
        
        List sorted = new LinkedList(freqList.entrySet());
        // Comparator voor de value
        Collections.sort(sorted, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                 return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        
        Map sortedMap = new LinkedHashMap();
	for (Iterator it = sorted.iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();
		sortedMap.put(entry.getKey(), entry.getValue());
	}
        
        Iterator it = sortedMap.entrySet().iterator();
        while (it.hasNext())
        {
            Entry e = (Entry) it.next();
            HuffTree.add(new Node((char)e.getKey(),(Integer)e.getValue()));
        }
        return HuffTree;
    }
}