import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tuple
{
    private ArrayList<String> states    = new ArrayList<>();
    private ArrayList<String> symbols   = new ArrayList<>();
    private Map<States, String> deltaNFA = new HashMap<>();
    private Map<States, String> delta = new HashMap<>();
    private String startState;
    private ArrayList<String> acceptStates    = new ArrayList<String>();
    private NFA nfa;
    private DFA dfa;
    private String[] inputArray;
    private String input;
    private int stateCounter = 0;
    RegEx regEx;

    public ArrayList tuple = new ArrayList();

    /**
     * Consturctor for NFA tuple
     * @param nfa tuple for nfa only
     */
    public Tuple(NFA nfa){
        symbols = nfa.getAlphabetList();
        this.nfa = nfa;
        tuple.add(symbols);

        setSplits();
        setStartState();
        tuple.add(startState);

        regEx = new RegEx(input);
        setAcceptStates();
        createStates();


    }

    /**
     * Getter for finding the state index
     * @return the current state index
     */
    public int getStateCounter() {
        return stateCounter;
    }

    /**
     * Remove the nfa tag from the input
     */
    public void setSplits(){
        input = nfa.getInput().replace("-n ","");
        inputArray= input.split("");

    }

    /**
     * Find the starting state / initial state of the string
     */
    public void setStartState() {
        int i = 0;
        while(i < inputArray.length && inputArray[i].equals("(")){
            startState = inputArray[i+1];
            i++;
        }

    }

    /**
     * Generate states based on the input string
     */
    public void createStates(){
        for(String s: regEx.finalStates.keySet()){
            states.add(s);
        }
    }
    public void setAcceptStates(){
        int b = inputArray.length -1;
        String tempEnd = null;
        for(int i = inputArray.length - 1 ; i >= 0 ; i--){
            if(!inputArray[i].equals(")") && !inputArray[i].equals("*")) {
               tempEnd = inputArray[i];
                break;
            }
        }
        acceptStates.add(tempEnd);
    }

    public Tuple(DFA dfa){

    }
    private void tupleNFA(String string){

    }
    public String toString() {
        return "states: "+ "" + " alphabet: "+symbols + " start state: "+ startState + " accepting states: "+acceptStates + " states : "+states;
    }

}
