import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  Main {

    public static void intro(){

        System.out.println("Welcome to Grephy, a convertor for regular expressions to NFA/DFA Diagrams");
        System.out.println("First, enter your REGEX pattern:");

        Scanner sc=new Scanner(System.in);

        System.out.println("Type in your command");
        String rollno=sc.nextLine().toLowerCase();
        Alphabet alphabet = new Alphabet(rollno);
        sc.close();
    }



    public static void main(String[] args){

        intro();

    }
}