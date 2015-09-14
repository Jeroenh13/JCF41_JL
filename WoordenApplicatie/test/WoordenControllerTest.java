/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.gui.WoordenController;

/**
 *
 * @author Lisa
 */
public class WoordenControllerTest {
    
    public WoordenControllerTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testWordCounter()
    {
        WoordenController controller = new WoordenController();
        String story = "een, twee, drie, vier, vijf\n"
            + "een, twee, drie, vier, vijf\n";   
        
        String testOutput = controller.wordCounter(story);
        String expectedOutput = "Aantal woorden: 10" + "\n" + "Aantal verschillende woorden: 5" ;
        Assert.assertEquals(expectedOutput.toString(), testOutput.toString());
    }
    
}
