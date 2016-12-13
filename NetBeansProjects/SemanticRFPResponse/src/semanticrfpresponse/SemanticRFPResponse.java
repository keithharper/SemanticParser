/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticrfpresponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kharper
 */
public class SemanticRFPResponse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        parseFile(args[0]);      
    }
    
    private static void parseFile(String file) {
        try {
            final Path path = FileSystems.getDefault().getPath(file);
            final List<String> lines = Files.readAllLines(path);
            final ArrayList<HashMap> parsedTerms = TermParser.parseTerms(lines);
            System.out.println(parsedTerms);
        } catch (IOException ex) {
            Logger.getLogger(SemanticRFPResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
