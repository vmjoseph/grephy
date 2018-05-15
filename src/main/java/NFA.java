import java.util.ArrayList;

public class NFA
{
    public Tuple nfaTuple;
    private ArrayList<String> alphabetList;
    private String input;

    /**
     * Constructor for regular NFA
     * @param input regex string to be used to check inputted string against
     */
    public NFA(String input)
    {
        // learn the alphabet of the regular expression
     Alphabet alphabet = new Alphabet(input);
     alphabetList = alphabet.getAlphabet();
     this.input = input;
    }

    /**
     * Getter for the alphabet learned from REGEX
     * @return alphabet learned from regex
     */
    public ArrayList<String> getAlphabetList()
    {
        return alphabetList;
    }

    /**
     * Setter to associate a tuple to an NFA
     * @param nfaTuple
     */
    public void setNfaTuple(Tuple nfaTuple) {
        this.nfaTuple = nfaTuple;
    }

    /**
     * Getter for the string to check for regex
     * @return
     */
    public String getInput()
    {
        return input;
    }
}
