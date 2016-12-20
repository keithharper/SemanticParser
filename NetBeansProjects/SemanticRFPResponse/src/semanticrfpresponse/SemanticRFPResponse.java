package semanticrfpresponse;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author kharper
 */
public class SemanticRFPResponse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length == 2) {
            beginParse(args[0], args[1]);
        }
        else {
            System.out.println("Usage: " + SemanticRFPResponse.class.getSimpleName() + " [/path/to/questions/file] [/path/to/responses/file]");
        }
    }
    
    private static void beginParse(String questionsFile, String responseFile) {
        final ArrayList<HashMap> parsedTerms = parseQuestionsFile(questionsFile);
        final List<String> responses = parseResponseFile(responseFile);
        mapParsedTermsToResponses(parsedTerms, responses);
        System.out.println(parsedTerms);
        System.out.println(responses);
    }
    
    private static ArrayList<HashMap> parseQuestionsFile(String file) {
        final List<String> lines = readFileIntoList(file);
        return TermParser.parseTerms(lines);
    }
    
    private static List<String> readFileIntoList(String file) {
        try {
            return Files.readAllLines(getPathToFile(file));
        } catch (IOException ex) {
            Logger.getLogger(SemanticRFPResponse.class.getName()).log(Level.SEVERE, null, ex);
            return Arrays.asList("");
        }
    }
    
    private static Path getPathToFile(String file) {
        return FileSystems.getDefault().getPath(file);
    }
    
    private static List<String> parseResponseFile(String file) {
        return readFileIntoList(file);
    }
    
    private static void mapParsedTermsToResponses(ArrayList<HashMap> parsedTerms, List<String> responses) {
        final List<String> terms = new ArrayList<>();
        
        for(HashMap pairsOfTerms : parsedTerms) {
            for(Object key : pairsOfTerms.keySet()) {
                terms.add(key.toString());
            }
            findTermsInResponses(terms, responses);
            terms.clear();
        }
    }
    
    private static void findTermsInResponses(List<String> question, List<String> responses) {
        HashMap<String, Integer> responseCount = new HashMap<>();
        for(String term : question) {
            getResponseCounts(responses, term, responseCount);
            Stream<Map.Entry<String, Integer>> test = responseCount.entrySet().stream().sorted();
            System.out.println("" + test.toString());
        }
        String maxKey = Collections.max(responseCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        //System.out.println("Question: " + question.toString());
        //System.out.println("Response: " + maxKey);
        //System.out.println("============================================================");
        System.out.println(maxKey);
    }

    private static void getResponseCounts(List<String> responses, String term, HashMap<String, Integer> responseCount) {
        for(String response : responses) {
            if(RegexHelper.applyRegexToSentence(response).contains(term)) {
                final Object previousCount = responseCount.putIfAbsent(response, 1);
                final boolean duplicateResponse = previousCount != null;
                
                if(duplicateResponse) {
                    responseCount.put(response, (int) previousCount + 1);
                }
                
                
            }
        }
    }
}
