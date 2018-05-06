import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  Main {

    public static void intro()
    {

        System.out.println("Welcome to Grephy, a convertor for regular expressions to NFA/DFA Diagrams");
        System.out.println("First, enter your REGEX pattern:");

        Scanner sc=new Scanner(System.in);

        System.out.println("Type in your command");
        String rollno=sc.nextLine().toLowerCase();

        DFA dfa = new DFA();
        if(isNFA(rollno)){
            NFA nfa = new NFA(rollno);
            Tuple tuple = new Tuple(nfa);
            nfa.setNfaTuple(tuple);
            System.out.println(nfa.nfaTuple);

        }

        sc.close();
    }

    public static boolean isNFA(String s)
    {
        if(s.contains("-n")){
            return true;
        }else if(s.contains("-d")){
            return false;
        }else{
            return false;
        }
    }


    public static void main(String[] args)
    {

        intro();

    }
}