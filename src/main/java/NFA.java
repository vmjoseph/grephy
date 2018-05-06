import java.util.ArrayList;

public class NFA
{
    public Tuple nfaTuple;
    private ArrayList<String> alphabetList;
    private String input;

    public NFA(String input)
    {
     Alphabet alphabet = new Alphabet(input);
     alphabetList = alphabet.getAlphabet();
     this.input = input;
    }

    public ArrayList<String> getAlphabetList()
    {
        return alphabetList;
    }

    public void setNfaTuple(Tuple nfaTuple) {
        this.nfaTuple = nfaTuple;
    }

    public String getInput()
    {
        return input;
    }
}
