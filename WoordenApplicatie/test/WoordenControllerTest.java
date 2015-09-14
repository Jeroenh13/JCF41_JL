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
    public void testWordCounter() {
        WoordenController controller = new WoordenController();
        String story = "een, twee, drie, vier, vijf\n"
                + "een, twee, drie, vier, vijf\n";

        String realOutput = controller.wordCounter(story);
        String expectedOutput = "Aantal woorden: 10" + "\n" + "Aantal verschillende woorden: 5";
        System.out.println(realOutput);
        System.out.println(expectedOutput);
        Assert.assertEquals(expectedOutput.toString(), realOutput.toString());
    }

    @Test
    public void testBackWardSort()
    {
        WoordenController controller = new WoordenController();
        String story = "a, c, b, f, d\n"
                + "h, e, g, j, i\n";
        String realOutput = controller.backwardSort(story);
        String expectedOutput = "j" + "\n"
                                + "i" + "\n"
                                + "h" + "\n"
                                + "g" + "\n"
                                + "f" + "\n"
                                + "e" + "\n"
                                + "d" + "\n"
                                + "c" + "\n"
                                + "b" + "\n"
                                + "a" + "\n";
        Assert.assertEquals(expectedOutput.toString(), realOutput.toString());                               
    }
<<<<<<< HEAD
=======
    
    @Test
    public void frequentTest()
    {
        WoordenController controller = new WoordenController();
        String story = "dit is een tekst waar vaker is en dit in voorkomt";
        
        String testOutput = controller.frequentie(story);
        String ExpectedOutput = "vaker=1\n" +
                                "in=1\n" +
                                "voorkomt=1\n" +
                                "tekst=1\n" +
                                "en=1\n" +
                                "waar=1\n" +
                                "een=1\n" +
                                "is=2\n" +
                                "dit=2\n" +
                                "";
        Assert.assertEquals(ExpectedOutput, testOutput);
    }
    
    @Test
    public void concordantieTest()
    {
        WoordenController controller = new WoordenController();
        String story = "Dit is een \nverhaal met meerdere regels. \nDit is een regel";
        
        String testOutput = controller.concordantie(story);
        String ExpectedOutput = "dit=1, 3\n" +
                                "een=1, 3\n" +
                                "is=1, 3\n" +
                                "meerdere=2\n" +
                                "met=2\n" +
                                "regel=3\n" +
                                "regels=2\n" +
                                "verhaal=2\n" +
                                "";
        
        Assert.assertEquals(ExpectedOutput, testOutput);
    }
>>>>>>> origin/master
}
