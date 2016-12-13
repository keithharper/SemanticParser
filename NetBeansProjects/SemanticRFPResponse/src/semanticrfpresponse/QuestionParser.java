package semanticrfpresponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kharper
 */
public class QuestionParser {
    private static final String REGEX_PATTERN_ALPHA_NUMERIC = "[^a-zA-Z ]";
    private static final String REGEX_COMMON_WORDS = "(?:^|(?<= ))("
            + "a|"
            + "all|"
            + "an|"
            + "and|"
            + "any|"
            + "as|"
            + "at|"
            + "are|"
            + "be|"
            + "been|"
            + "being|"
            + "by|"
            + "can|"
            + "contains|"
            + "each|"
            + "etc|"
            + "for|"
            + "from|"
            + "has|"
            + "if|"
            + "in|"
            + "is|"
            + "it|"
            + "not|"
            + "of|"
            + "on|"
            + "one|"
            + "or|"
            + "our|"
            + "p|"
            + "was|"
            + "were|"
            + "where|"
            + "with|"
            + "so|"
            + "than|"
            + "that|"
            + "the|"
            + "this|"
            + "to"
            + ")(?:(?= ))";
            
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
        final HashMap terms = new HashMap();
        for(String term : sentence.replaceAll(REGEX_PATTERN_ALPHA_NUMERIC, "").replaceAll(REGEX_COMMON_WORDS, "").split(" ")) {
            if(!term.isEmpty()) {
                final Object termCount = terms.putIfAbsent(term, 1);
            
                if(termCount != null) {
                    terms.put(term, Integer.parseInt(termCount.toString()) + 1);
                }
            }
        }
        return terms;
    }
    
    
}
