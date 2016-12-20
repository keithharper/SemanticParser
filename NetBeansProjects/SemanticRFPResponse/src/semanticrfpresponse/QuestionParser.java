package semanticrfpresponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kharper
 */
public class QuestionParser {
    /**
     *
     * @param unparsedQuestions
     * @param separator
     * @return ArrayList<String> returns a vector separated by the specified separator
     */
    public static List<String> parseStringBySeparator(String unparsedQuestions, String separator) {
        return Arrays.asList(unparsedQuestions.split(separator));
    }
    
    public static HashMap parseTermsFromSentence(String sentence) {
        final HashMap<String, Integer> terms = new HashMap<>();
        
        for(String term : sentence.split(" ")) {
            if(!term.isEmpty()) {
                final Object previousTermCount = terms.putIfAbsent(term, 1);
                final boolean duplicateTerm = previousTermCount != null;
                
                if(duplicateTerm) {
                    terms.put(term, (int) previousTermCount + 1);
                }
            }
        }
        
        return terms;
    }   
    
}
