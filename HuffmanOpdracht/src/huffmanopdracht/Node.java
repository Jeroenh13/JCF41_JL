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
public class Node {
    private char character;
    private int value;
    private Node left,right;
    
    private Node(char c)
    {
        character = c;
    }
    
    private Node(char c, int v)
    {
        character = c;
        value = v;
    }
    
    public char getCharacter()
    {
        return character;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public Node getNode(String side)
    {
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
    
    public void setNode(String side, Node n)
    {
        switch (side) {
            case "Left":
            case "left":
                left = n;
                break;
            case "Right":
            case "right":
                right = n;
                break;
        }
    }
    
    
    
}
