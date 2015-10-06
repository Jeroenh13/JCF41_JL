/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanopdracht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
public final class HuffmanController {

    Map<Character, String> bitCodes = new HashMap<>();

    public HuffmanController(){
        
    };
    
    
    private static final String DEFAULT_TEXT
            = "liesje leerde lotje lopen langs de lange lindelaan";

    public void SimulateHuffman() {
        List<Node> nodes = getFrequencyTree(DEFAULT_TEXT);
        List<Node> sortedNodes = sortHuffman(nodes);
        Node HuffmanRoot = makeHuffmanTree(sortedNodes);
        createBitCodes(HuffmanRoot, "");

        String bitCode = getBitCode(DEFAULT_TEXT);
        System.out.println(bitCode);
        System.out.println(DecodeBitCode(bitCode, HuffmanRoot));
    }

    private void createBitCodes(Node root, String bitCode) {
        if (root.getCharacter() == '\u0000') {
            createBitCodes(root.getNode("left"), bitCode.concat("0"));
            createBitCodes(root.getNode("right"), bitCode.concat("1"));
        } else {
            bitCodes.put(root.getCharacter(), bitCode);
        }
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
        while (it.hasNext()) {
            Entry e = (Entry) it.next();
            HuffTree.add(new Node((char) e.getKey(), (Integer) e.getValue()));
        }
        return HuffTree;
    }

    private List<Node> sortHuffman(List<Node> us) {
        Collections.sort(us, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (((Node) (o2)).compareTo((Node) (o1)));
            }
        });
        return us;
    }

    private Node makeHuffmanTree(List<Node> list) {
        while (list.size() > 1) {
            Node left = list.get(0);
            Node right = list.get(1);
            int newFrequency = left.getValue() + right.getValue();

            Node newNode = new Node(newFrequency, left, right);

            list.remove(left);
            list.remove(right);
            list.add(newNode);

            list = this.sortHuffman(list);
        }

        return list.get(0);
    }

    private String getBitCode(String input) {
        StringBuilder sb = new StringBuilder();
        char[] ch = input.toCharArray();

        for (char c : ch) {
            sb.append(bitCodes.get(c));
        }

        return sb.toString();
    }

    private String DecodeBitCode(String bitCode, Node HuffmanRoot) {
        Node currentNode = HuffmanRoot;
        StringBuilder sb = new StringBuilder();

        char[] bits = bitCode.toCharArray();
        for (char c : bits) {
            if (c == '0') {
                if (currentNode.getNode("left") != null) {
                    currentNode = currentNode.getNode("left");
                }
            } else if (c == '1') {
                if (currentNode.getNode("right") != null) {
                    currentNode = currentNode.getNode("right");
                }
            }

            if (currentNode.getNode("left") == null && currentNode.getNode("right") == null) {
                sb.append(currentNode.getCharacter());
                currentNode = HuffmanRoot;
            }
        }
        return sb.toString();
    }
}
