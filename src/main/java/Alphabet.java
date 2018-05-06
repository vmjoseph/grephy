import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alphabet {
    private ArrayList<String> alphabet = new ArrayList<>();
    final String regex = "([a-z]*\\*)|([a-z]*)|([a-z]*\\s*\\+\\s*[a-z]*)|(\\([a-z]*\\s*\\+\\s*[a-z]*\\)\\*)|([a-z]*\\s*\\+\\s*\\ε)";

    public ArrayList<String> findAlphabet(String input) {
        ArrayList<String> acceptedAlphabet = new ArrayList<>();
       ArrayList<String> fullAcceptedAlphabet = new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            acceptedAlphabet.add(matcher.group(0));
        }
        for(String s : acceptedAlphabet){
            if(s.length() > 0 && !s.contains("*")) {
                fullAcceptedAlphabet.add(s);
            }
        }
        System.out.println("Alphabet accepted: \n"+fullAcceptedAlphabet);
        alphabet = fullAcceptedAlphabet;
        return fullAcceptedAlphabet;
    }

    public Alphabet(String input){
        findAlphabet(input);
    }

    public ArrayList<String> getAlphabet(){return  alphabet;}

    public String getRegex(){return regex;}
}