package semanticrfpresponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kharper
 */
public class TermParser {
    public static ArrayList<HashMap> parseTerms(List<String> questions) {
        final ArrayList<HashMap> parsedTerms = new ArrayList<>();
        
        for (String question : questions) {
            parsedTerms.add(
                    QuestionParser.parseTermsFromSentence(
                            RegexHelper.applyRegexToSentence(question.toLowerCase()))
            );
        }
        
        return parsedTerms;
    }
    
}
