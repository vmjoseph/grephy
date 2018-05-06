import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tuple {
    private ArrayList<States> states    = new ArrayList<States>();
    private ArrayList<String> symbols   = new ArrayList<>();
    private Map<States, String> deltaNFA = new HashMap<>();
    private Map<States, String> delta = new HashMap<>();
    private String startState;
    private ArrayList<States> acceptStates    = new ArrayList<States>();

    private ArrayList tuple = new ArrayList();

    public Tuple(NFA nfa){

    }
    public Tuple(DFA dfa){

    }
    private void tupleNFA(String string){

    }

}
