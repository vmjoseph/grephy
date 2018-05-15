import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DFA
{
    public NFA nfa;
    private ArrayList<String> stateTransitions = new ArrayList<>();
    public DFA(NFA nfa)
    {
        this.nfa = nfa;
        stateTransitions = nfa.nfaTuple.getStates();
        stateTransitions = nfa.nfaTuple.getStates();
        nfaTable();
    }

    public void nfaTable(){

        final String regex = "(q\\d*\\s*\\-\\>\\s*q\\d*)\\[label\\s*=(\\s*\\d*)\\]";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        for(int i =0; i < stateTransitions.size(); i++){
            for(int j = 1; j < stateTransitions.size(); j++){
//                System.out.println(stateTransitions.get(i) +" on " + stateTransitions.get(j));
                final Matcher matcher = pattern.matcher(stateTransitions.get(i));
                final Matcher matcher1 = pattern.matcher(stateTransitions.get(j));

                while (matcher.find() && matcher1.find()) {
//                    System.out.println("Full match: " + matcher1.group(0));
                    for (int k = 1; k <= matcher1.groupCount(); k++) {
//                        System.out.println("Group " + k + ": " + matcher1.group(k));
//                        System.out.println("Group " + k + ": " + matcher.group(k));
                    }
                }
            }
        }
    }
}

