/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanopdracht;

/**
 *
 * @author jeroe
 */
public class Node implements Comparable {

    private char character;
    private int value;
    private Node left, right;

    /**
     * Makes a new empty node with value and parents
     *
     * @param v frequency
     * @param left parent, can be null
     * @param right parent, can be null
     */
    private Node(int v, Node left, Node right) {
        value = v;
        this.left = left;
        this.right = right;
    }
    
    Node(int v) {
        value = v;
    }

    Node(char c, int v) {
        character = c;
        value = v;
    }

    public char getCharacter() {
        return character;
    }

    public int getValue() {
        return value;
    }

    public Node getNode(String side) {
        switch (side) {
            case "Left":
            case "left":
                return left;
            case "Right":
            case "right":
                return right;
        }
        return null;
    }

    @Override
    public int compareTo(Object o) {
        if (((Node) o).value > this.value) {
            return 1;
        } else if (((Node) o).value < this.value) {
            return -1;
        } else {
            return 0;
        }
    }
}
