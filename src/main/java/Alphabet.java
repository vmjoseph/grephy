import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alphabet {
    private ArrayList<String> alphabet = new ArrayList<>();
    // string to look for the main types of pattern matching
    final String regex = "([a-z]*\\*)|([a-z]*)|([a-z]*\\s*\\+\\s*[a-z]*)|(\\([a-z]*\\s*\\+\\s*[a-z]*\\)\\*)|([a-z]*\\s*\\\\+\\s*\\ε)|(\\([a-z]*\\s*\\\\+\\s[a-z]*\\)\\([a-z]*\\s*\\+\\s[a-z]*\\))|([a-z]*\\*)|([0-1]*)";
    public Alphabet(String input){
        findAlphabet(input);
    }

    /**
     * Searches through the user file for languages used in regex
     * @param input user input
     * @return list of strings (without * + or () )
     */
    private ArrayList<String> findAlphabet(String input) {

        ArrayList<String> acceptedAlphabet = new ArrayList<>();
        ArrayList<String> fullAcceptedAlphabet = new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            acceptedAlphabet.add(matcher.group(0));
//            System.out.println(matcher.group(0));
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        for(String s : acceptedAlphabet){

            if(s.length() > 0) {
                fullAcceptedAlphabet.add(s);
            }
        }

        System.out.println("Alphabet accepted: \n"+fullAcceptedAlphabet);
        alphabet = fullAcceptedAlphabet;
        return fullAcceptedAlphabet;
    }

    public ArrayList<String> getAlphabet(){return  alphabet;}

    public String getRegex(){return regex;}
}
