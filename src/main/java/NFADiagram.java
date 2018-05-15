import java.util.ArrayList;

public class NFADiagram {
    public String header;
    public String acceptingStates;
    String end= ";";
    public String fullEnd = "}";
    public String states;
    public String headerAccept=  " \t node [shape = doublecircle]; ";

    public NFADiagram(ArrayList<String> states , ArrayList<String> acceptingStates){
        addAcceptingStates(acceptingStates);
        header = "digraph graphname {\n" +
                "\t rankdir=LR;\n" +
                "\t size=\"8,5\" \n "+
                headerAccept+
                "\n \t node [shape = circle];";
        this.states +="\n";
        for(int i = 0; i < states.size(); i++){
//            System.out.println(states.get(i));
            if(i == states.size()){
                this.states += ("\t "+states.get(i) + "\n");
            }else if(states.get(i)!= null) {
                this.states += ("\t "+states.get(i) + "\n");
            }
        }
    }
    public void addAcceptingStates(ArrayList<String> acceptingStates){
        headerAccept+= acceptingStates.get(acceptingStates.size() - 1 )+";";
    }

    public String toString(){
        return header+states.replace("null","")+fullEnd;
    }
    /**-n (0+1(01*0)*1)*
     * digraph graphname {
     rankdir=LR;
     size="8,5"
     node [shape = doublecircle]; q0;
     node [shape = circle];
     q0 -> q1 [label = 1];
     q0 -> q0 [label = 0];
     q1 -> q0 [label = 1];
     q1 -> q2 [label = 0];
     q2 -> q1 [label = 0];
     q2 -> q2;

     }
     */
}
