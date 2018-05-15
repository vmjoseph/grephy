import java.util.ArrayList;
class States {
    // Prefix for all state names
    String name = "q";
    // Easier access of sequential states
    String relation = "";

    /**
     * General constructor for normal states
     * @param stateNumber index of the state
     */
    States(int stateNumber)
    {
        this.name = name + String.valueOf(stateNumber);
    }

    /**
     * Constructor for if the input matches a pattern which suggests the nfa accepts a certain sequence of strings
     * @param stateNumber index of the state
     * @param relation sequential state
     */
    States(int stateNumber, String relation)
    {
        this.name = name + String.valueOf(stateNumber);
        this.relation = relation;
    }

    /**
     * Allow editing of state name prefix
     * @param name prefix to be changed to
     */
    public void setStateNames(String name){this.name = name;};

    /**
     * Override of system.out.print for states
     * @return
     */
    public String toString() {
        return "Name: "+ name + " Relations: "+relation;
    }

}
