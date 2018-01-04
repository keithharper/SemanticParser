/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticrfpresponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author kharper
 */
public class QuestionParserTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of parseStringBySeparator method, of class Parser.
     */
    @Test
    public void testParseStringBySeparator() {
        System.out.println("parseStringBySeparator");
        String unparsedQuestions = "test"
                + "\r\ntest1"
                + "\r\ntest2";
        String separator = "\r\n";
        List<String> expResult = Arrays.asList("test", "test1", "test2");
        List<String> result = QuestionParser.parseStringBySeparator(unparsedQuestions, separator);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseTermsFromSentence method, of class QuestionParser.
     */
    @Test
    public void testParseTermsFromSentence() {
        System.out.println("parseTermsFromSentence");
        String sentence = "This is a is a sample sentence to determine if all of the common words are removed.";
        HashMap expResult = new HashMap();
        expResult.put("This", 1);
        expResult.put("determine", 1);
        expResult.put("common", 1);
        expResult.put("sample", 1);
        expResult.put("sentence", 1);
        expResult.put("words", 1);
        expResult.put("removed", 1);
        HashMap result = QuestionParser.parseTermsFromSentence(sentence);
        assertEquals(expResult, result);
    }
    
}
