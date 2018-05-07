import java.util.ArrayList;
class States {
    String name = "q";
    String relation = "";

    // constructor has type of data that is required
    States(int stateNumber)
    {
        // initialize the input variable from main
        // function to the global variable of the class
        this.name = name + String.valueOf(stateNumber);
    }

    States(int stateNumber, String relation)
    {
        // initialize the input variable from main
        // function to the global variable of the class
        this.name = name + String.valueOf(stateNumber);
        this.relation = relation;
    }
    public void setStateNames(String name){this.name = name;};

    public String toString() {
        return "Name: "+ name + " Relations: "+relation;
    }

}
