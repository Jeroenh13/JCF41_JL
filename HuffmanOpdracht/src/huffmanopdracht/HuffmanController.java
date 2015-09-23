/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanopdracht;

import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lisa
 */
public class HuffmanController {
    
    public HuffmanController(){};
           

    private static final String DEFAULT_TEXT = 
             "liesje leerde lotje lopen langs de lange lindelaan";
    
    public String internGetFrequentie()
    {
        String s = getFrequentie(DEFAULT_TEXT);
        return s;
    }

    private String getFrequentie(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> freqList = new LinkedHashMap<>();

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
        StringBuilder sb = new StringBuilder();
        Iterator it = sorted.iterator();
        while (it.hasNext())
        {
            sb.append(it.next()+"\n");
        }
        return sb.toString();
    }
}
