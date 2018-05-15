import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private String input;
    public Helpers helpers;
    public Map<Integer, String> exploded;
    public ArrayList<States> states;
    public HashMap<String, String> finalStates= new HashMap<>();
    public  int o;
    private enum types{
        ab, abAndC, baKleen,  aAndBKleen,abAndE, emptySet
    }
    private enum precedence{
        plus, concat
    }
    public RegEx(String input){
        this.input = input;
        exploded = evaluate();
        chooseEvaluation();
    }

    /**
     * From https://www.moreofless.co.uk/check-string-contains-number-using-java/
     * @param s input string of either letters or digits
     * @return boolean value: true = number false  = only letters
     */
    public boolean stringContainsNumber( String s )
    {
        Pattern p = Pattern.compile( "[0-9]" );
        Matcher m = p.matcher( s );

        return m.find();
    }

    public Map<Integer, String> evaluate(){
//        System.out.println("Input: ");
//        System.out.println(input);
        int i = 0;
        Map<Integer, String> groups = new HashMap<>();

        final String regex = "(\\([a-z]*\\s*\\+\\s*[a-z]*\\s*\\)\\*)|(\\([a-z]*\\s*\\+\\s*[a-z]*\\s*\\)\\s*\\*)|([a-z]*)";
        final String regexDigit = "([0-1]*\\*[0-1]*)|(\\([0-1]*\\*[0-1]*\\))|([0-1]*\\s*\\+\\s*[0-1])|(\\([0-1]*\\s*\\+\\s*[0-1]\\))";
        final String complexDigit = "(\\([0-1]*\\*[0-1]*\\)\\*)|(\\([0-1]*\\s\\+\\s*[0-1]*.*\\)\\*)|([0-1]*\\s*\\+\\s*[0-1])|([0-1]*)";

        Pattern pattern;
        Matcher matcher;
        if(stringContainsNumber(input)){
            pattern = Pattern.compile(complexDigit, Pattern.MULTILINE);
            matcher = pattern.matcher(input);
        }else{
            pattern = Pattern.compile(regex, Pattern.MULTILINE);
            matcher = pattern.matcher(input);
        }

        while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
            if(!matcher.group(0).equals("")) {
                groups.put(i, matcher.group(0));
                i++;
            }
        }
        return groups;
    }

    private void chooseEvaluation() {
//        System.out.println("EXPLODDED:");
//        System.out.println(exploded);
        ArrayList<String> stateNames = new ArrayList<>();
        o = 0;
        for(int i = 0; i < exploded.size(); i++){
            System.out.println(i+ " "+ exploded.get(i));
//            stateNames.add("q"+p+": "+exploded.get(i));
//            p++;
            if(exploded.get(i).contains("+")){
                computePlus(exploded.get(i),stateNames,o);
            }else if(exploded.get(i).contains("*") && !exploded.get(i).contains("+")){
                computeKleene(exploded.get(i),stateNames,o);
            }else if (exploded.get(i).contains("*") && exploded.get(i).contains("+")){
                computeKleenePlus(exploded.get(i),stateNames,o);
            }else{
                o += 1;
                System.out.println("Reg compute");
                System.out.println(exploded.get(i));
                if(exploded.get(i).length() < 1) {
                    String string = ("q" + (o + 1) + " -> " + "q" + (o + 1) + "[label = " + exploded.get(i) + "];");
                    finalStates.put(string, "q" + (o + 1));
                    stateNames.add("q" + o + ": " + exploded.get(i));
                }else {
                    String[] explodeAgain = exploded.get(i).split("");
                    for(String s: explodeAgain){
                        System.out.println(s);
                        String string = ("q" + (o-1 ) + " -> " + "q" + (o) + "[label = " + s + "];");
                        finalStates.put(string, "q" + (o));
                        stateNames.add("q" + (o+1) + ": " + exploded.get(i));

                        o+=1;
                    }
                }
            }
        }

//        for ( String key : finalStates.keySet() ) {
//            System.out.println( key );
//        }
    }

    private void computePlus(String s, ArrayList<String> stateNames, int o){
        o+=1;
//        System.out.println("Plus Compute");
//        System.out.println(s);
        String[] splitPlus = s.split("\\+");
        if(splitPlus.length>1){
            String string = ("q"+(0)+ " -> " +"q"+(o-1)+"[label = "+splitPlus[0]+"];");
            finalStates.put(string,"q"+(0));
            String strings = ("q"+(0)+ " -> " +"q"+(o)+"[label = "+splitPlus[1]+"];");
            finalStates.put(strings,"q"+(0));
        }
    }
    private void computeKleene(String s, ArrayList<String> stateNames, int o){

        o+=1;
        System.out.println("Kleene Compute");
        System.out.println(s);
        String[] strings = s.split("(?<=\\*)");
        for(String str: strings){
            String tempLast ="";
            String tempRealLast = "";
            String[] allString= str.replace(")","").replace("(","").split("");
//            System.out.println( str + " Split more:");
            for(String strs: allString){
                if(!strs.contains("*")){
//                    System.out.println("q"+(o)+ "->" +"q"+(o-1)+" [label = "+strs+"];");
                    tempRealLast=  strs;
                }else{
                    String string = ("q"+(o)+ " -> " +"q"+(o-1) + "[label = "+tempRealLast+"];");
                    finalStates.put(string,"q"+(o));
                    String stringss = ("q"+(o-1)+ " -> " +"q"+(o) + "[label = "+tempRealLast+"];");
                    finalStates.put(stringss,"q"+(o-1));
                }

            }
//            System.out.println("q"+0+ "->" +"q"+(o)+" [label = "+splitPlus[0]+"];");
//            System.out.println("q"+0+ "->" +"q"+(o)+" [label = "+splitPlus[1]+"];");
        o+=1;
        }

    }
    private void computeKleenePlus(String s, ArrayList<String> stateNames, int o){
        o+=1;
//        System.out.println("Kleene Plus Compute");
//        System.out.println(s);

    }

}
