import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alphabet
{
    private final Helpers helpers;
    private ArrayList<String> alphabet = new ArrayList<>();
    // string to look for the main types of pattern matching
    final String regex = "([a-z]*\\*)|([a-z]*)|([a-z]*\\s*\\+\\s*[a-z]*)|(\\([a-z]*\\s*\\+\\s*[a-z]*\\)\\*)|([a-z]*\\s*\\\\+\\s*\\ε)|(\\([a-z]*\\s*\\\\+\\s[a-z]*\\)\\([a-z]*\\s*\\+\\s[a-z]*\\))|([a-z]*\\*)";
    //use digit searcher for strings containing digits
    final String digitRegex = "([0-1]*\\s*\\+\\s*[0-1]*)|([0-1]*)";

    /**
     * Constructor
     * @param input file read in
     */
    public Alphabet(String input)
    {
        findAlphabet(input);
        helpers = new Helpers();
    }
    /**
     * From https://www.moreofless.co.uk/check-string-contains-number-using-java/
     * @param s input string of either letters or digits
     * @return boolean value: true = number false  = only letters
     */
    public boolean stringContainsNumber( String s )
    {
        Pattern p = Pattern.compile( "[0-9]" );
        Matcher m = p.matcher( s );

        return m.find();
    }

    /**
     * Searches through the user file for languages used in regex
     * @param input user input
     * @return list of strings (without * + or () )
     */
    private ArrayList<String> findAlphabet(String input)
    {
        boolean containLetter = stringContainsNumber(input);
        ArrayList<String> acceptedAlphabet = new ArrayList<>();
        ArrayList<String> fullAcceptedAlphabet = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;

        if(!containLetter){
             pattern = Pattern.compile(regex, Pattern.MULTILINE);
             matcher = pattern.matcher(input);
        }else{
            pattern = Pattern.compile(digitRegex, Pattern.MULTILINE);
            matcher = pattern.matcher(input);
        }

        while (matcher.find()) {
            acceptedAlphabet.add(matcher.group(0));
        }

        for(String s : acceptedAlphabet){
            if(s.length() > 0 && !s.equals("n") && !s.equals("d") && !s.equals("*")) {
                fullAcceptedAlphabet.add(s);
            }
        }

//        System.out.println("Alphabet accepted: \n"+fullAcceptedAlphabet);
        alphabet = fullAcceptedAlphabet;
        return fullAcceptedAlphabet;

    }

    /**
     * Getter for the learned alphabet
     * @return
     */
    public ArrayList<String> getAlphabet(){return  alphabet;}

    /**
     * Getter for the regex used against the regex file
     * @return regex file
     */
    public String getRegex(){return regex;}
}
