/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AS21 13
 */
public class PelotaTest {
    
    public PelotaTest() {
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
     * Test of getPelota method, of class Pelota.
     */
    @Test
    public void testGetPelota() {
        System.out.println("getPelota");
        Pelota instance = null;
        Rectangle2D expResult = null;
        Rectangle2D result = instance.getPelota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reinicioP1 method, of class Pelota.
     */
    @Test
    public void testReinicioP1() {
        System.out.println("reinicioP1");
        Rectangle limites = null;
        boolean colisionPP1 = false;
        Pelota instance = null;
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reinicioP2 method, of class Pelota.
     */
    @Test
    public void testReinicioP2() {
        System.out.println("reinicioP2");
        Rectangle limites = null;
        boolean colisionPP2 = false;
        Pelota instance = null;
        int expResult = 0;
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class Pelota.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Rectangle limites = null;
        boolean colisionP1 = false;
        boolean colisionP2 = false;
        Pelota instance = null;
        instance.mover(limites, colisionP1, colisionP2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
