/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanopdracht;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeroen Hendriks
 */
public class HuffmanControllerTest {
    
    public HuffmanControllerTest() {
        HuffmanController c = new HuffmanController();
        c.SimulateHuffman();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createHuffMan method, of class HuffmanController.
     */
    @Test
    public void testCreateHuffMan() {
        System.out.println("createHuffMan");
        HuffmanController instance = new HuffmanController();
        instance.SimulateHuffman();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
