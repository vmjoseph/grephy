import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tuple
{
    private ArrayList<States> states    = new ArrayList<States>();
    private ArrayList<String> symbols   = new ArrayList<>();
    private Map<States, String> deltaNFA = new HashMap<>();
    private Map<States, String> delta = new HashMap<>();
    private String startState;
    private ArrayList<States> acceptStates    = new ArrayList<States>();
    private NFA nfa;
    private DFA dfa;
    private String[] inputArray;
    private String input;

    public ArrayList tuple = new ArrayList();

    public Tuple(NFA nfa){
        symbols = nfa.getAlphabetList();
        this.nfa = nfa;
        tuple.add(symbols);

        setSplits();
        setStartState();
        tuple.add(startState);
        System.out.println("Symbols: " +symbols);
        System.out.println("Start State: " +startState);

    }
    public void setSplits(){
        input = nfa.getInput().replace("-n ","");
        inputArray= input.split("");

    }

    public void setStartState() {
        int i = 0;
        while(i < inputArray.length && inputArray[i].equals("(")){
            startState = inputArray[i+1];
            i++;
        }

    }
    public void setAcceptStates(){

    }

    public Tuple(DFA dfa){

    }
    private void tupleNFA(String string){

    }
    public String toString() {
        return "states: "+ "" + " alphabet: "+symbols + " start state: "+ startState;
    }

}
