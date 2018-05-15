import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    public Helpers(){

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

}
