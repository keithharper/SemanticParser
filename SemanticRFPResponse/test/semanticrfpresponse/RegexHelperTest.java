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
public class RegexHelperTest {
    
    public RegexHelperTest() {
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
     * Test of applyRegexToSentence method, of class RegexHelper.
     */
    @Test
    public void testApplyRegexToSentence() {
        System.out.println("applyRegexToSentence");
        String sentence = "This is a test to confirm that the regex pattern is still valid.";
        String expResult = "   test  confirm   regex pattern  still valid";
        String result = RegexHelper.applyRegexToSentence(sentence.toLowerCase());
        assertEquals(expResult, result);
    }
    
}
