/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticrfpresponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kharper
 */
public class SemanticRFPResponseTest {
    
    public SemanticRFPResponseTest() {
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
     * Test of main method, of class SemanticRFPResponse.
     */
    @Test
    public void testMainOneArg() {
        System.out.println("main with 1 arg");
        String[] args = {"/Users/kharper/questions.txt"};
        SemanticRFPResponse.main(args);
    }
    
    @Test
    public void testMainTwoArgs() {
        System.out.println("main with 2 args");
        String[] args = {"/Users/kharper/questions.txt", "/Users/kharper/responses.txt"};
        SemanticRFPResponse.main(args);
    }
}
